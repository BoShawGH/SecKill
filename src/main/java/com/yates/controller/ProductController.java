package com.yates.controller;

import com.yates.entity.Product;
import com.yates.service.ProductService;
import com.yates.vo.CustomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @RequestMapping(value = "/toapplyproduct")
    public String toapplyProduct(){
        return "/product/applyproduct";
    }

    @RequestMapping(value = "/applyproduct")
    public String applyProduct(Product product){
        productService.applyProduct(product);
        return "redirect:/product/listproduct";
    }

    @RequestMapping(value = "/delete")
    public String deleteProductById(int id){
        productService.deleteProductById(id);
        return "redirect:/product/listproduct";
    }

    @RequestMapping(value = "/toupdate")
    public String toUpdate(HttpServletRequest request, int id){
        Product product = productService.queryProductById(id);
        LocalDateTime startTime = product.getStartTime();
        LocalDateTime endTime = product.getEndTime();
        String startTimeString = "";
        String endTimeString = "";
        if(startTime != null){
            startTimeString = dateFormat.format(startTime);
            product.setStartTimeString(startTimeString);
        }
        if(endTime != null){
            endTimeString = dateFormat.format(endTime);
            product.setEndTimeString(endTimeString);
        }
        request.setAttribute("product", product);
//        request.setAttribute("startTime", startTimeString);
//        request.setAttribute("endTime", endTimeString);
        return "/product/update";
    }
    
    @RequestMapping(value = "/update")
    public String updateProduct(HttpServletRequest request, Product product){
        product.setStartTime(LocalDateTime.parse(product.getStartTimeString(), dateFormat));
        product.setEndTime(LocalDateTime.parse(product.getEndTimeString(), dateFormat));
        productService.updateProduct(product);
        return "redirect:/product/listproduct";
    }

    @RequestMapping(value = "/toupdatestate")
    public String toUpdateProductState(HttpServletRequest request, int id){
        Product product = productService.queryProductById(id);
        LocalDateTime startTime = product.getStartTime();
        LocalDateTime endTime = product.getEndTime();
        String startTimeString = "";
        String endTimeString = "";
        if(startTime != null){
            startTimeString = dateFormat.format(startTime);
            product.setStartTimeString(startTimeString);
        }
        if(endTime != null){
            endTimeString = dateFormat.format(endTime);
            product.setEndTimeString(endTimeString);
        }
        request.setAttribute("product", product);
//        request.setAttribute("startTime", startTimeString);
//        request.setAttribute("endTime", endTimeString);
        return "/product/auditproduct";
    }

    @RequestMapping(value = "updatestate")
    public String updateProductState(HttpServletRequest request, int id, int state){
        productService.updateProductState(id, state);
        return "redirect:/product/listproduct";
    }
    @RequestMapping(value = "/querybyid")
    public String queryProductById(HttpServletRequest request, int id){
        Product product = productService.queryProductById(id);
        request.setAttribute("product", product);
        return "/product/query";
    }

    @RequestMapping(value="/listproduct")
    public String queryProducts(HttpServletRequest request, CustomVo customVo){
        List<Product> products = productService.queryProducts(customVo);
        request.setAttribute("products", products);
        return "/product/list";
    }
}
