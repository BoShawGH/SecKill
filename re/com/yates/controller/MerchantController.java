package com.yates.controller;

import com.yates.entity.Merchant;
import com.yates.service.MerchantService;
import com.yates.vo.CustomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    public MerchantService merchantService;

    @RequestMapping("/toinsert")
    public String toinsert() {
        return "/merchant/insert";
    }

    @RequestMapping(value = "/insert")
    public String insert(Merchant merchantInfo) {
        System.out.println(merchantInfo);
        merchantService.insertMerchant(merchantInfo);
        return "redirect:/merchant/querymerchants";
    }

    @RequestMapping("/toupdate")
    public String toUpdate(HttpServletRequest request, int id) {
        Merchant merchant = merchantService.queryMerchantById(id);
        request.setAttribute("merchant", merchant);
        return "/merchant/update";
    }

    @RequestMapping(value = "/update")
    public String update(HttpServletRequest request, Merchant merchant) {
        merchantService.updateMerchant(merchant);
        System.out.println(merchant);
        return "redirect:/merchant/querymerchants";
    }

    @RequestMapping("/delete")
    public String toDelete(HttpServletRequest request, int id) {
        merchantService.deleteMerchantById(id);
        return "redirect:/merchant/querymerchants";
    }

    @RequestMapping("/querybyid")
    public String queryMerchantById(HttpServletRequest request, int id) {
        Merchant merchant = merchantService.queryMerchantById(id);
        request.setAttribute("merchant", merchant);
        return "/merchant/query";
    }

    @RequestMapping("/querymerchants")
    public String queryMerchants(HttpServletRequest request, CustomVo customVo) {
        List<Merchant> merchants = merchantService.queryMerchants(customVo);
        request.setAttribute("merchantlist", merchants);
        return "/merchant/list";
    }
}