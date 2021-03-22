package com.yates.controller;

import com.yates.entity.Merchant;
import com.yates.exception.IdNotNullOrEmptyException;
import com.yates.service.MerchantService;
import com.yates.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "merchant")
public class MerchantController{
    @Autowired
    MerchantService merchantService;

    @RequestMapping(value="toinsert")
    public String toInsert(){
        return "/merchant/insert";
    }

    @RequestMapping(value="insert")
    public String insertMerchant(Merchant merchant) throws IdNotNullOrEmptyException {
        if(merchant.getMerchantId() == null || merchant.getMerchantId().equals(""))
            throw new IdNotNullOrEmptyException();
        merchantService.insertMerchant(merchant);
        return "redirect:/merchant/listall";
    }
    @RequestMapping(value = "delete")
    public String deleteMerchantById(String merchantId) throws IdNotNullOrEmptyException{
        if(merchantId == null || merchantId.equals(""))
            throw new IdNotNullOrEmptyException();
        merchantService.deleteMerchantById(merchantId);
        return "redirect:/merchant/listall";
    }

    @RequestMapping(value = "toupdate")
    public String toUpdate(HttpServletRequest request, String merchantId) throws IdNotNullOrEmptyException{
        if(merchantId.equals("") || merchantId == null)
            throw new IdNotNullOrEmptyException();
        Merchant merchant = merchantService.queryMerchantById(merchantId);
        request.setAttribute("merchant", merchant);
        return "/merchant/update";
    }

    @RequestMapping(value="update")
    public String updateMerchant(HttpServletRequest request, Merchant merchant){
        merchantService.updateMerchant(merchant);
        return "redirect:/merchant/listall";
    }

    @RequestMapping(value = "querybyid")
    public String queryMerchantById(HttpServletRequest request, String merchantId) throws IdNotNullOrEmptyException{
        if(merchantId == null || merchantId.equals(""))
            throw new IdNotNullOrEmptyException();
        Merchant merchant = merchantService.queryMerchantById(merchantId);
        request.setAttribute("merchant", merchant);
        return "/merchant/query";
    }

    @RequestMapping(value = "querybyaccount")
    public String queryMerchantByAccount(HttpServletRequest request, String merchantAccount) throws IdNotNullOrEmptyException {
        if(merchantAccount == null || merchantAccount.equals(""))
            throw new IdNotNullOrEmptyException();
        Merchant merchant = merchantService.queryMerchantByAccount(merchantAccount);
        request.setAttribute("merchant", merchant);
        return "/merchant/query";
    }

    @RequestMapping(value = "listall")
    public String queryAll(HttpServletRequest request, CommonVo commonVo){
        List<Merchant> merchants = merchantService.queryAll(commonVo);
        request.setAttribute("merchants", merchants);
        return "/merchant/list";
    }
}
