package com.yates.controller;

import com.yates.common.DateConverter;
import com.yates.entity.Order;
import com.yates.entity.Product;
import com.yates.entity.ProductDetail;
import com.yates.entity.SecUser;
import com.yates.exception.IdNotNullOrEmptyException;
import com.yates.service.OrderService;
import com.yates.service.ProductDetailService;
import com.yates.service.ProductService;
import com.yates.service.SecUserService;
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
    public String queryOrderByUserId(HttpServletRequest request, String userId) throws IdNotNullOrEmptyException{
        if(userId == null || userId.equals(""))
            throw new IdNotNullOrEmptyException();
        List<Order> orders = orderService.queryOrderByUserId(userId);
        request.setAttribute("orders", orders);
        return "/order/view.jsp";
    }
}
