package com.yates.controller;

import com.yates.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/mhome")
public class MHomeController {
    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "/index")
    public String index(){
        return "/mhome/index.jsp";
    }

    @RequestMapping(value="/error")
    public String error(){
        return "/mhome/error.jsp";
    }
}
