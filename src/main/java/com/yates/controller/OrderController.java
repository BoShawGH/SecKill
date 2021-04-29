package com.yates.controller;

import com.mysql.cj.Session;
import com.sun.tools.corba.se.idl.constExpr.Or;
import com.yates.common.DateConverter;
import com.yates.entity.Order;
import com.yates.entity.Product;
import com.yates.entity.ProductDetail;
import com.yates.entity.SecUser;
import com.yates.exception.IdNotNullOrEmptyException;
import com.yates.service.OrderService;
import com.yates.service.ProductDetailService;
import com.yates.service.ProductService;
import com.yates.service.pay.AliPay;
import com.yates.service.pay.BankPay;
import com.yates.service.pay.WeChatPay;
import com.yates.vo.CommonVo;
import com.yates.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDetailService productDetailService;
    @Autowired
    private AliPay aliPay;
    @Autowired
    private BankPay bankPay;
    @Autowired
    private WeChatPay weChatPay;

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

    @RequestMapping(value = "/togenerate")
    public String toGenerateOrder(HttpServletRequest request, String productId, int num){
        LocalDateTime now = LocalDateTime.now();
        Order order = new Order();
        order.setProductId(productId);
        Product product = productService.queryProductById(productId);
        if(product != null){
            order.setMerchantId(product.getMerchantId());
        }
        HttpSession session = request.getSession();
        SecUser user = (SecUser)session.getAttribute("user");
        if(user != null){
            order.setUserId(user.getUserId());
        }
        BigDecimal payAmount = product.getSecPrice().multiply(BigDecimal.valueOf(num));
        order.setCreateTime(now);
        order.setPayAmount(payAmount);
        order.setTransQuantity(num);
        LocalDateTime payTime = DateConverter.convert("1900-01-01 01:00:00", "yyyy-MM-dd HH:mm:ss");
        order.setPayTime(payTime);
        order.setPayState("0");
        String transserial = DateConverter.date2String(now, "yyyyMMddHHmmssSSS") + String.valueOf((int)(Math.random()*900 + 100));
        order.setTransSerial(transserial);
        orderService.insertOrder(order);
        session.setAttribute("transserial", transserial);
        request.setAttribute("product", product);
        request.setAttribute("num", num);
        request.setAttribute("payAmount", payAmount);
        return "/order/payorder.jsp";
    }

    @RequestMapping(value = "pay")
    public String pay(HttpServletRequest request, String payType, BigDecimal payAmount, Order order){
        int payRes=0;
        HttpSession session = request.getSession();
        String transserial = (String)session.getAttribute("transserial");
        if("1".equals(payType)) {
            payRes = aliPay.payWithOrder(payAmount, transserial);
        }else if("2".equals(payType)){
            payRes = weChatPay.payWithOrder(payAmount, transserial);
        }else{
            payRes = bankPay.payWithOrder(payAmount,transserial);
        }
        if(payRes != 0) {
            CommonVo commonVo = new CommonVo();
            OrderVo orderVo = new OrderVo();
            orderVo.setTransSerial(transserial);
            orderVo.setPayState(String.valueOf(payRes));
            orderVo.setPayTime(LocalDateTime.now());
            orderVo.setPayType(payType);
            orderVo.setReceivingAddress(order.getReceivingAddress());
            orderVo.setReceivingPhone(order.getReceivingPhone());
            orderVo.setReceivingName(order.getReceivingName());
            commonVo.setOrderVo(orderVo);
            orderService.updateOrder(commonVo);
        }
        session.removeAttribute("transserial");
        session.removeAttribute("product");
        session.removeAttribute("payAmount");
        session.removeAttribute("num");
        return "redirect:/uhome/index";
    }

    @RequestMapping(value = "querybyid")
    public String queryById(HttpServletRequest request){
        HttpSession session = request.getSession();
        SecUser user = (SecUser) session.getAttribute("user");
        List<Order> orders = orderService.queryOrderByUserId(user.getUserId());
        request.setAttribute("orders", orders);
        return "/order/meview.jsp";
    }
}
