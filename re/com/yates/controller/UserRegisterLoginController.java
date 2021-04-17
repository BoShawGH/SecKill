package com.yates.controller;

import com.yates.entity.User;
import com.yates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "sign_up_in")
public class UserRegisterLoginController {
    @Autowired
    public UserService userService;

    @RequestMapping(value = "/tosignup")
    public String toSignUp(){
        return "user/signup";
    }
    @RequestMapping(value = "/signup")
    public String register(HttpServletRequest request, User user){
        userService.insertUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "/userHome/index";
    }

    @RequestMapping(value = "tosignin")
    public String toSignIn(){
        return "user/signin";
    }
    @RequestMapping(value = "signin")
    public String login(HttpServletRequest request, User user){

        String account = user.getUserAccount();
        String password = user.getUserPassword();
        User userResult = userService.queryByAccount(account);
        if(userResult == null){
            System.out.println("无此用户");
            request.setAttribute("errorInfo", "无此用户");
        }else if(!userResult.getUserPassword().equals(password)){
            System.out.println("密码错误");
            request.setAttribute("errorInfo", "密码错误");
        }else{
            HttpSession session =request.getSession();
            session.setAttribute("user", userResult);
            return "/userHome/index";
        }
        return "/userHome/error";
    }

    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "/userHome/index";
    }
}
