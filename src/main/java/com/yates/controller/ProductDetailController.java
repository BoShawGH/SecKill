package com.yates.controller;

import com.alibaba.fastjson.JSONObject;
import com.yates.entity.Product;
import com.yates.entity.ProductDetail;
import com.yates.exception.IdNotNullOrEmptyException;
import com.yates.service.ProductDetailService;
import com.yates.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.management.InstanceNotFoundException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/detail")
public class ProductDetailController {
    @Autowired
    public ProductDetailService productDetailService;
    @Autowired
    public ProductService productService;

    @RequestMapping(value = "/toinsert")
    public String toInsert(HttpServletRequest request, String productId) throws IdNotNullOrEmptyException, InstanceNotFoundException {
        if(productId == null || productId.equals(""))
            throw new IdNotNullOrEmptyException("商品号不能为空");
        Product product = productService.queryProductById(productId);
        if( product == null)
            throw new InstanceNotFoundException("商品不存在");
        if(productDetailService.queryByProductId(productId) != null)
            return "商品详细信息已存在，请不要重复添加";
        String merchantId = product.getMerchantId();
        String productTitle = product.getProductTitle();
        request.setAttribute("productId", productId);
        request.setAttribute("merchantId", merchantId);
        request.setAttribute("productTitle", productTitle);
        return "/detail/insert.jsp";
    }

    @RequestMapping(value = "/insert")
    public String insertDetail(ProductDetail detail){
        productDetailService.insertDetail(detail);
        return "redirect:/product/listall";
    }

    @RequestMapping(value = "/toupdate")
    public String toUpdate(HttpServletRequest request, String productId) throws IdNotNullOrEmptyException, InstanceNotFoundException{
        if(productId == null || productId.equals(""))
            throw new IdNotNullOrEmptyException("商品号不能为空");
        ProductDetail productDetail = productDetailService.queryByProductId(productId);
        if(productDetail == null)
            throw new InstanceNotFoundException("商品不存在");
        request.setAttribute("detail", productDetail);
        return "/product/update.jsp";
    }

    @RequestMapping(value = "update")
    public String updateDetail(HttpServletRequest request, ProductDetail productDetail){
        productDetailService.updateDetail(productDetail);
        return "/product/listall";
    }

    @RequestMapping(value = "query")
    public String queryByProductId(HttpServletRequest request, String productId) throws IdNotNullOrEmptyException{
        if(productId == null || productId.equals(""))
            throw new IdNotNullOrEmptyException("商品号不能为空");
        ProductDetail detail = productDetailService.queryByProductId(productId);
        request.setAttribute("productDetail", detail);
        return "/detail/view.jsp";
    }
}