package com.yates.controller;

import com.yates.entity.User;
import com.yates.service.UserService;
import com.yates.vo.CustomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/toinsert")
    public String toInsert(){
        return "/user/insert";
    }

    @RequestMapping(value = "/insert")
    public String insertUser(User user){
        userService.insertUser(user);
        return "redirect:/user/queryusers";
    }

    @RequestMapping(value = "/toupdate")
    public String toUpdate(HttpServletRequest request, int id){
        User user = userService.queryUserById(id);
        request.setAttribute("user", user);
        return "/user/update";
    }

    @RequestMapping(value = "/update")
    public String updateUser(HttpServletRequest request, User user){
        userService.updateUser(user);
        return "redirect:/user/queryusers";
    }

    @RequestMapping(value="/delete")
    public String deleteUserById(int id){
        userService.deleteUserById(id);
        return "redirect:/user/queryusers";
    }

    @RequestMapping(value="/querybyid")
    public String queryUserById(HttpServletRequest request, int id){
        User user = userService.queryUserById(id);
        request.setAttribute("user", user);
        return "/user/query";
    }

    @RequestMapping(value = "/queryusers")
    public String queryUsers(HttpServletRequest request, CustomVo customVo){
        List<User> users = userService.queryUsers(customVo);
        request.setAttribute("users", users);
        return "/user/list";
    }
}
