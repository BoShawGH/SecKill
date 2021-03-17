package com.yates.controller;

import com.yates.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "order")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @RequestMapping(value = "toinsert")
    public String toInsert(){
        return "/order/insert";
    }
}
