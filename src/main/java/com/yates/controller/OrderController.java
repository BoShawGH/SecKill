package com.yates.controller;

import com.yates.entity.Order;
import com.yates.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "order")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @RequestMapping(value = "insert")
    public String toInsert(HttpServletRequest request, Order order){
        return "123";
    }
}
