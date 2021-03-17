package com.yates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "merchanthome")
public class MerchantHomeController {
    @RequestMapping(value = "index")
    public String index(){
        return "/merchantHome/index";
    }
}
