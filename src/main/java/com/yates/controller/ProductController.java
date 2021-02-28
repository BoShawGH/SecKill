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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    private DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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

    @RequestMapping(value = "/querybyid")
    public String queryProductById(HttpServletRequest request, int id){
        Product product = productService.queryProductById(id);
        request.setAttribute("product", product);
        return "/product/view";
    }

    @RequestMapping(value = "/delete")
    public String deleteProductById(int id){
        productService.deleteProductById(id);
        return "redirect:/product/listproducts";
    }

    @RequestMapping(value = "/toupdate")
    public String toUpdateById(HttpServletRequest request, int id){
        Product product = productService.queryProductById(id);
        String startTime = product.getStartTime().format(dateTimeFormatter);
        String endTime = product.getEndTime().format(dateTimeFormatter);
        request.setAttribute("product", product);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        return "/product/update";
    }

    @RequestMapping(value = "/update")
    public String updateProductById(HttpServletRequest request, Product product, String startTimeString, String endTimeString){
//        if(!startTimeString.equals(product.getStartTimeString())){
//            product.setStartTimeString(startTimeString);
//            product.setStartTime(LocalDateTime.parse(startTimeString, dateTimeFormatter));
//        }
//        if(!endTimeString.equals(product.getEndTimeString())){
//            product.setEndTimeString(endTimeString);
//            product.setEndTime(LocalDateTime.parse(endTimeString, dateTimeFormatter));
//        }

        productService.updateProduct(product);
        return "redirect:/product/listproducts";
    }

    @RequestMapping(value = "toupdatestate")
    public String toUpdateState(HttpServletRequest requset, int id){
        Product product = productService.queryProductById(id);
        requset.setAttribute("product", product);
        return "/product/auditproduct";
    }
    @RequestMapping(value = "/updatestate", method = RequestMethod.GET)
    public String updateProductState(int id, int state){
        productService.updateProductState(id, state);
        return "redirect:/product/listproducts";
    }

}
