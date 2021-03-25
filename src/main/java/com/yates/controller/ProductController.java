package com.yates.controller;

import com.yates.common.DateConverter;
import com.yates.entity.Merchant;
import com.yates.entity.Product;
import com.yates.exception.IdNotNullOrEmptyException;
import com.yates.service.MerchantService;
import com.yates.service.ProductService;
import com.yates.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.management.InstanceNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    public ProductService productService;
    @Autowired
    public MerchantService merchantService;

    public DateConverter dateConverter = new DateConverter();

    @RequestMapping(value = "/toinsert")
    public String toInsert(){
//        Product product = new Product();
        return "/product/insert";
    }

    @RequestMapping(value = "/insert")
    public String insertProduct(Product product) throws IdNotNullOrEmptyException, InstanceNotFoundException {
        if(product.getProductId() == null || product.getProductId().equals("")){
            throw new IdNotNullOrEmptyException("商品号不存在或者为空");
        }
        if(product.getMerchantId() == null || product.getMerchantId().equals("")){
            throw new IdNotNullOrEmptyException("商家号不存在或者为空");
        }else{
            Merchant merchant = merchantService.queryMerchantById(product.getMerchantId());
            if(merchant == null)
                throw new InstanceNotFoundException("商家不存在");
        }
        LocalDateTime applyDate = LocalDateTime.now();
        product.setApplyDate(applyDate);
        product.setStartTime(dateConverter.convert(product.getStartTimeString()));
        product.setEndTime(dateConverter.convert(product.getEndTimeString()));
        productService.insertProduct(product);
        return "redirect:/product/listall";
    }

    @RequestMapping(value="/delete")
    public String deleteById(String productId) throws IdNotNullOrEmptyException {
        if(productId == null || productId.equals(""))
            throw new IdNotNullOrEmptyException("商品号不存在或者为空");
        productService.deleteById(productId);
        return "redirect:/product/listall";
    }

    @RequestMapping(value="/toupdate")
    public String toUpdate(HttpServletRequest request, String productId) throws IdNotNullOrEmptyException, InstanceNotFoundException {
        if(productId == null || productId.equals(""))
            throw new IdNotNullOrEmptyException("商品号不存在或者为空");
        Product product = productService.queryProductById(productId);
        if(product == null)
            throw new InstanceNotFoundException("该商品不存在");
        String st = product.getStartTimeString();
        String et = product.getEndTimeString();
        request.setAttribute("product", product);
        return "/product/update";
    }

    @RequestMapping(value = "/update")
    public String updateProduct(HttpServletRequest request, Product product) throws IdNotNullOrEmptyException, InstanceNotFoundException {
        if(product.getProductId() == null || product.getProductId().equals("")){
            throw new IdNotNullOrEmptyException("商品号不存在或者为空");
        }
        if(product.getMerchantId() == null || product.getMerchantId().equals("")){
            throw new IdNotNullOrEmptyException("商家号不存在或者为空");
        }else{
            Merchant merchant = merchantService.queryMerchantById(product.getMerchantId());
            if(merchant == null)
                throw new InstanceNotFoundException("商家不存在");
        }

        product.setApplyDate(dateConverter.convert(product.getApplyDateString()));
        product.setAuditDate(dateConverter.convert(product.getAuditDateString()));
        product.setStartTime(dateConverter.convert(product.getStartTimeString()));
        product.setEndTime(dateConverter.convert(product.getEndTimeString()));
        productService.updateProduct(product);
        return "redirect:/product/listall";
    }

    @RequestMapping(value = "toaudit")
    public String toAudit(HttpServletRequest request, String productId) throws IdNotNullOrEmptyException, InstanceNotFoundException {
        if(productId == null || productId.equals(""))
            throw new IdNotNullOrEmptyException("商品号不存在或为空");
        Product product = productService.queryProductById(productId);
        if(product == null)
            throw new InstanceNotFoundException("商品不存在");
        request.setAttribute("product", product);
        return "/product/auditproduct";
    }

    @RequestMapping(value="audit")
    public String auditProduct(HttpServletRequest request, String productId, int state) throws IdNotNullOrEmptyException{
        if(productId == null || productId.equals(""))
            throw new IdNotNullOrEmptyException("商品号不存在或为空");
        productService.auditProduct(productId, state);
        return "redirect:/product/listall";
    }

    @RequestMapping(value = "/query")
    public String queryProductById(HttpServletRequest request, String productId) throws IdNotNullOrEmptyException{
        if(productId == null || productId.equals(""))
            throw new IdNotNullOrEmptyException("商品好不存在或者为空");
        Product product = productService.queryProductById(productId);
        request.setAttribute("product", product);
        return "/product/view";
    }

    @RequestMapping(value = "/listall")
    public String queryAll(HttpServletRequest request, CommonVo commonVo){
        List<Product> products = productService.queryAll(commonVo);
        request.setAttribute("products", products);
        return "/product/list";
    }
}