package com.yates.controller;

import com.yates.entity.Merchant;
import com.yates.service.MerchantService;
import com.yates.vo.CustomVo;
import com.yates.vo.MerchantVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @RequestMapping("/toinsert")
    public String toinsert(){
        return "/merchant/insert";
    }
    @RequestMapping(value = "/insert", produces = {"application/text;charset=UTF-8"})
    public void insert(Merchant merchantInfo){
        System.out.println(merchantInfo);
        merchantService.insertMerchant(merchantInfo);
    }

    @RequestMapping("/toupdate")
    public String toUpdate(HttpServletRequest request, int id){
        Merchant merchant = merchantService.queryMerchantById(id);
        request.setAttribute("merchant", merchant);
        return "/merchant/update";
    }
    @RequestMapping(value="/update",produces = {"application/text;charset=UTF-8"})
    public void update(HttpServletRequest request, Merchant merchant){
        merchantService.updateMerchant(merchant);
        System.out.println(merchant);
    }

    @RequestMapping("/delete")
    public void toDelete(HttpServletRequest request, int id){
       merchantService.deleteMerchantById(id);
    }

    @RequestMapping("/querybyid")
    public String queryOneInfo(HttpServletRequest request, int id){
        Merchant merchant = merchantService.queryMerchantById(id);
        request.setAttribute("merchant", merchant);
        return "/merchant/query";
    }

    @RequestMapping("/querymerchants")
    public String queryMerchants(HttpServletRequest request, CustomVo customVo){
        List<Merchant> merchants =  merchantService.queryMerchants(customVo);
        request.setAttribute("merchantlist", merchants);
        return "/merchant/list";
    }
}