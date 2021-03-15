package com.yates.controller;

import com.yates.entity.ProductDetail;
import com.yates.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/detail")
public class ProductDetailController {
    @Autowired
    public ProductDetailService productDetailService;

    @RequestMapping(value = "/toinsert")
    public String toInsert(HttpServletRequest request, Integer productId, Integer merchantId){
        request.setAttribute("productId", productId);
        request.setAttribute("merchantId", merchantId);
        return "/detail/insert";
    }

    @RequestMapping(value = "/insert")
    public String insertDetail(ProductDetail productDetail){
        productDetailService.insertDetail(productDetail);
        return "redirect:/product/listproducts";
    }

    @RequestMapping(value = "/toupdate")
    public String toUpdate(HttpServletRequest request, int productId){
        ProductDetail productDetail = productDetailService.queryById(productId);
        request.setAttribute("productDetail", productDetail);
        return "/detail/update";
    }

    @RequestMapping(value = "/update")
    public String updateDetail(HttpServletRequest request, ProductDetail productDetail){
        productDetailService.updateDetail(productDetail);
        return "/product/list";
    }

    @RequestMapping(value = "querybyid")
    public String queryDetailById(HttpServletRequest request, int productId){
        ProductDetail productDetail = productDetailService.queryById(productId);
        request.setAttribute("productDetail", productDetail);
        return "/detail/view";
    }
}
