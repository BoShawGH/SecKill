package com.yates.controller;

import com.yates.entity.Merchant;
import com.yates.entity.SecUser;
import com.yates.exception.IdNotNullOrEmptyException;
import com.yates.service.MerchantService;
import com.yates.service.SecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "sign")
public class SignModuleController {
    @Autowired
    private SecUserService secUserService;
    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "usignup")
    public String uSignUp(HttpServletRequest request){
        return "/secuser/signup.jsp";
    }

    @RequestMapping(value = "signup")
    public String signUp(HttpServletRequest request, SecUser secUser) throws IdNotNullOrEmptyException {
        String userId = secUser.getUserId();
        if(userId == null || userId.equals("")){
            throw new IdNotNullOrEmptyException("客户号不能为空");
        }
        secUserService.insertUser(secUser);
        HttpSession session = request.getSession();
        session.setAttribute("user", secUser);
        return "redirect:/uhome/index";
    }

    @RequestMapping(value = "usignin")
    public String uSignIn(HttpServletRequest request){
        return "/secuser/signin.jsp";
    }

    @RequestMapping(value = "signin")
    public String signIn(HttpServletRequest request, SecUser user){
        String userAccount = user.getUserAccount();
        String pass = user.getUserPassword();
        HttpSession session = request.getSession();

        SecUser newUser = secUserService.queryUserByAccount(userAccount);
        if(newUser == null){
            String errorInfo = "用户不存在";
            session.setAttribute("errorInfo", errorInfo);
            return "/uhome/error.jsp";
        }
        else if(!newUser.getUserPassword().equals(pass)){
            String errorInfo = "密码错误";
            session.setAttribute("errorInfo", errorInfo);
            return "/uhome/error.jsp";
        }
        else{
            session.setAttribute("user", newUser);
            return "redirect:/uhome/index";
        }
    }

    @RequestMapping(value = "usignoff")
    public String uSignOff(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/uhome/index";
    }

    @RequestMapping(value = "msignup")
    public String mSignUp(HttpServletRequest request){
        return "/merchant/signup.jsp";
    }

    @RequestMapping(value = "musignup")
    public String muSignUp(HttpServletRequest request, Merchant merchant) throws IdNotNullOrEmptyException{
        String merchantId = merchant.getMerchantId();
        if(merchantId == null || merchantId.equals("")){
            throw new IdNotNullOrEmptyException("商家号不合法");
        }
        merchantService.insertMerchant(merchant);
        HttpSession session = request.getSession();
        session.setAttribute("merchant", merchant);
        return "redirect:/mhome/index";
    }

    @RequestMapping(value = "msignin")
    public String mSignIn(HttpServletRequest request){
        return "/merchant/signin.jsp";
    }

    @RequestMapping(value = "musignin")
    public String muSignIn(HttpServletRequest request, Merchant merchant){
        String merchantAccount = merchant.getMerchantAccount();
        String pass = merchant.getMerchantPassword();
        HttpSession session = request.getSession();
        Merchant newMerchant = merchantService.queryMerchantByAccount(merchantAccount);
        if(newMerchant == null){
            String errorInfo = "账号不存在";
            session.setAttribute("errorInfo", errorInfo);
        }else if(!newMerchant.getMerchantPassword().equals(pass)){
            String errorInfo = "密码错误";
            session.setAttribute("errorInfo", errorInfo);
        }else{
            session.setAttribute("merchant", newMerchant);
            return "redirect:/mhome/index";
        }
        return "redirect:/mhome/error";
    }

    @RequestMapping(value = "msignoff")
    public String mSignOff(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("merchant");
        return "redirect:/mhome/index";
    }
}
