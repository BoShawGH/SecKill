package com.yates.controller;

import com.yates.entity.DataResult;
import com.yates.entity.SecUser;
import com.yates.exception.IdNotNullOrEmptyException;
import com.yates.service.SecUserService;
import com.yates.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class SecUserController {
    @Autowired
    public SecUserService secUserService;

    @RequestMapping(value="/toinsert")
    public String toInsert(){
        return "/secuser/insert.jsp";
    }

    @RequestMapping(value="/insert")
    public @ResponseBody DataResult insertUser(SecUser user) throws IdNotNullOrEmptyException {
        if(user.getUserId() == null || user.getUserId().equals(""))
            throw new IdNotNullOrEmptyException();
        DataResult dataResult = new DataResult();
        int status = secUserService.checkUser(user.getUserId());
        if(status == 0){
            dataResult.setStatusCode(0);
            dataResult.setMessage("Id重复");
            dataResult.setData(user);
            return dataResult;
        }
        try {
            secUserService.insertUser(user);
            dataResult.setStatusCode(1);
            dataResult.setMessage("插入成功");
        }catch (Exception ex){
            dataResult.setStatusCode(0);
            dataResult.setMessage("数据插入失败");
            dataResult.setData(user);
        }
        return dataResult;
    }

    @RequestMapping(value="/delete")
    public String deleteUserById(String userId)throws IdNotNullOrEmptyException{
        if(userId == null || userId.equals(""))
            throw new IdNotNullOrEmptyException();
        secUserService.deleteUserById(userId);
        return "redirect:/user/listall";
    }

    @RequestMapping(value="/toupdate")
    public String toupdate(HttpServletRequest request, String userId) throws IdNotNullOrEmptyException{
        if(userId == null || userId.equals(""))
            throw new IdNotNullOrEmptyException();
        SecUser secUser = secUserService.queryUserById(userId);
        request.setAttribute("user", secUser);
        return "/secuser/update";
    }

    @RequestMapping(value="/update")
    public String updateUser(HttpServletRequest request, SecUser secUser){
        secUserService.updateUser(secUser);
        return "redirect:/user/listall";
    }

    @RequestMapping(value="/querybyid")
    public String queryById(HttpServletRequest request, String userId) throws IdNotNullOrEmptyException{
        if(userId == null || userId.equals(""))
            throw new IdNotNullOrEmptyException();
        SecUser secUser = secUserService.queryUserById(userId);
        request.setAttribute("user", secUser);
        return "/secuser/query";
    }

    @RequestMapping(value="/querybyaccount")
    public String queryByAccount(HttpServletRequest request, String userAccount){
        SecUser secUser = secUserService.queryUserByAccount(userAccount);
        request.setAttribute("user", secUser);
        return "/secuser/query";
    }

    @RequestMapping(value="/listall")
    public String queryAll(HttpServletRequest request, CommonVo commonVo){
        List<SecUser> users =  secUserService.queryAll(commonVo);
        request.setAttribute("users", users);
        return "/secuser/list.jsp";
    }
}
