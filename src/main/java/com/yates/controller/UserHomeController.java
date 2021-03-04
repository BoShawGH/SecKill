package com.yates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/userhome")
public class UserHomeController {
    @RequestMapping(value = "/index")
    public String index(){
        return "/userHome/index";
    }
}
