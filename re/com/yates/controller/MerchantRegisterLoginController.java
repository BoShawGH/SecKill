package com.yates.controller;

import com.yates.entity.Merchant;
import com.yates.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "merchant_sign")
public class MerchantRegisterLoginController {
    @Autowired
    MerchantService merchantService;

    @RequestMapping(value = "tosignup")
    public String toSignUp(){
        return "merchant/signup";
    }

    @RequestMapping(value = "signup")
    public String signUp(HttpServletRequest request, Merchant merchant){
        Merchant result = merchantService.queryMerchantByAccount(merchant.getMerchantAccount());
        HttpSession session = request.getSession();
        if(result == null) {
            merchantService.insertMerchant(merchant);
            session.setAttribute("merchant", merchant);
            return "/merchantHome/index";
        }else{
            return "redirect:/merchant_sign/tosignup";
        }
    }

    @RequestMapping(value = "tosignin")
    public String toSignIn(){
        return "merchant/signin";
    }

    @RequestMapping(value = "signin")
    public String signIn(HttpServletRequest request, Merchant merchant){
        String account = merchant.getMerchantAccount();
        String password = merchant.getMerchantPassword();
        Merchant result = merchantService.queryMerchantByAccount(account);
        HttpSession session = request.getSession();
        if(result == null){
            session.setAttribute("errorInfo", "用户不存在");
        }else if(!result.getMerchantPassword().equals(password)) {
            session.setAttribute("errorInfo", "密码错误");
        }else{
            session.setAttribute("merchant", merchant);
            return "/merchantHome/index";
        }
        return "/merchantHome/error";
    }

    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("merchant");
        return "/merchantHome/index";
    }
}
