package com.yates.controller;

import com.sun.tools.corba.se.idl.constExpr.Or;
import com.yates.common.DateConverter;
import com.yates.entity.*;
import com.yates.exception.IdNotNullOrEmptyException;
import com.yates.service.OrderService;
import com.yates.service.ProductDetailService;
import com.yates.service.ProductService;
import com.yates.service.SecUserService;
import com.yates.service.pay.AliPay;
import com.yates.service.pay.BankPay;
import com.yates.service.pay.WeChatPay;
import com.yates.vo.CommonVo;
import com.yates.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value = "order")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @Autowired
    public ProductDetailService productDetailService;

    @Autowired
    public ProductService productService;
    @Autowired
    AliPay aliPay;
    @Autowired
    WeChatPay weChatPay;
    @Autowired
    BankPay bankPay;

    @RequestMapping(value = "/detail")
    public String detail(HttpServletRequest request, String productId) throws IdNotNullOrEmptyException {
        if(productId == null || productId.equals("")){
            throw new IdNotNullOrEmptyException("商品号非法");
        }
        Product product = productService.queryProductById(productId);
        ProductDetail productDetail = productDetailService.queryByProductId(productId);
        if(product == null || productDetail == null){
            throw new IdNotNullOrEmptyException("商品信息不全，请联系管理员");
        }
        request.setAttribute("product", product);
        request.setAttribute("productDetail", productDetail);
        return "/order/sellDetail.jsp";
    }

    @RequestMapping(value = "/insert")
    public String generateOrder(HttpServletRequest request, int num, String productId){
        Product product = productService.queryProductById(productId);
        request.setAttribute("product", product);
        request.setAttribute("num", num);
        BigDecimal payAmount = product.getSecPrice().multiply(BigDecimal.valueOf(num));
        request.setAttribute("payAmount", payAmount);
        HttpSession session = request.getSession();
        SecUser user = (SecUser)session.getAttribute("user");
        if(user != null){
            request.setAttribute("userId", user.getUserId());
        }else{
            request.setAttribute("error", "请重新登录");
            return "/secuser/signin.jsp";
        }
        return "/order/payorder.jsp";
    }

    @RequestMapping(value = "/payorder")
    public String payOrder(HttpServletRequest request, Order order){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime payTime = DateConverter.convert("1900-01-01 01:00:00", "yyyy-MM-dd HH:mm:ss");
        order.setPayTime(payTime);
        order.setCreateTime(now);
        order.setPayState("0");
        String transerial = DateConverter.date2String(now, "yyyyMMddHHmmssSSS") + String.valueOf((int)(Math.random()*900 + 100));
        order.setTransSerial(transerial);
        orderService.insertOrder(order);
        return "redirect:/uhome/index";
    }

    @RequestMapping(value = "/querybyid")
    public String queryOrderByUserId(HttpServletRequest request){
        HttpSession session = request.getSession();
        SecUser user = (SecUser)session.getAttribute("user");
        if(user == null){
            request.setAttribute("errorInfo", "未登录");
            return "/secuser/signin.jsp";
        }
        String userId = user.getUserId();
        List<Order> orders = orderService.queryOrderByUserId(userId);
        request.setAttribute("orders", orders);
        return "/order/view.jsp";
    }

    @RequestMapping(value = "/cancelorder")
    public String cancelOrder(HttpServletRequest request, String transSerial) throws IdNotNullOrEmptyException{
        if(transSerial == null || transSerial.equals(""))
            throw new IdNotNullOrEmptyException("流水号不合法");
        orderService.cancelOrder(transSerial);
        return "redirect:/uhome/index";
    }

    @RequestMapping(value = "/topay")
    public String topay(HttpServletRequest request, String transSerial){
        Order order = orderService.queryOrderByTransSerial(transSerial);
        HttpSession session = request.getSession();
        if(order == null)
            return "redirect:/order/querybyid";
        session.setAttribute("transSerial", transSerial);
        Product product = productService.queryProductById(order.getProductId());
        request.setAttribute("product", product);
        request.setAttribute("num", order.getTransQuantity());
        request.setAttribute("payAmount", order.getPayAmount());
        return "/order/payorder.jsp";
    }

    /**
     *
     * @param request
     * @param payType 1:AliPay 2:WeChat 3:BankCard
     * @param payAmount
     * @return
     */
    @RequestMapping(value="/pay")
    public String payOrder(HttpServletRequest request,String payType,BigDecimal payAmount){
        int payRes = 0;
        String transSerial = (String)request.getSession().getAttribute("transSerial");
        if("1".equals(payType)) {
            payRes = aliPay.payWithOrder(payAmount, transSerial);
        }else if("2".equals(payType)){
            payRes = weChatPay.payWithOrder(payAmount, transSerial);
        }else{
            payRes = bankPay.payWithOrder(payAmount,transSerial);
        }
        if(payRes != 0) {
            CommonVo commonVo = new CommonVo();
            OrderVo orderVo = new OrderVo();
//            Order order = orderService.queryOrderByTransSerial(transSerial);
//            order.setPayType(payType);
//            order.setPayState(String.valueOf(payRes));
            orderVo.setTransSerial(transSerial);
            orderVo.setPayState(String.valueOf(payRes));
            orderVo.setPayType(payType);
            orderVo.setPayTime(LocalDateTime.now());
            commonVo.setOrderVo(orderVo);
            orderService.updateOrder(commonVo);
        }
        return "redirect:/order/querybyid";
    }

    @RequestMapping(value = "merchantquery")
    public String merchantQuery(HttpServletRequest request){
        HttpSession session = request.getSession();
        Merchant merchant = (Merchant)session.getAttribute("merchant");
        if(merchant == null){
            String errorInfo = "错误";
            request.setAttribute("errorInfo", errorInfo);
            return "/mhome/error.jsp";
        }
        List<Order> orders = orderService.merchantQuery(merchant.getMerchantId());
        request.setAttribute("orders", orders);
        return "/order/meview.jsp";
    }

    @RequestMapping(value = "/applyrefund")
    public String applyRefund(HttpServletRequest request, String transSerial){
        HttpSession session = request.getSession();
        SecUser user = (SecUser)session.getAttribute("user");
        if(user != null) {
            orderService.applyRefund(transSerial, "3");
            return "redirect:/order/querybyid";
        }else{
            return "/secuser/signin.jsp";
        }
    }
}
