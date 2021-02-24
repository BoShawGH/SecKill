package com.yates.controller;

import com.yates.entity.Product;
import com.yates.service.ProductService;
import com.yates.vo.CustomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/toapply")
    public String toApply(){
        return "/product/applyproduct";
    }

    @RequestMapping(value = "/applyproduct", method = RequestMethod.GET)
    public String applyProduct(Product product){
        productService.applyProduct(product);
        return "redirect:/product/listproducts";
    }

    @RequestMapping(value = "/listproducts")
    public String listProducts(HttpServletRequest request, CustomVo customVo){
        List<Product> products = productService.listProducts(customVo);
        request.setAttribute("products", products);
        return "/product/list";

    }
}
