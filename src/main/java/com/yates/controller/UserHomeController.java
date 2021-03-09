package com.yates.controller;

import com.yates.entity.Product;
import com.yates.service.ProductService;
import com.yates.vo.CustomVo;
import com.yates.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/userhome")
public class UserHomeController {
    @Autowired
    ProductService productService;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request){
        ProductVo productVo = new ProductVo();
        CustomVo customVo = new CustomVo();
        productVo.setStartTimeRangeFloor(LocalDateTime.now());
//        productVo.setStartTimeRangeFloor("2021-03-08 23:23:23");
        productVo.setAuditState(1);
        customVo.setProductVo(productVo);
        List<Product> products = productService.listProducts(customVo);
        request.setAttribute("products", products);
        return "/userHome/index";
    }
}
