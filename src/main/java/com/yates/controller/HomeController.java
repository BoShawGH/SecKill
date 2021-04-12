package com.yates.controller;

import com.yates.entity.Product;
import com.yates.service.ProductService;
import com.yates.service.SecUserService;
import com.yates.vo.CommonVo;
import com.yates.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(value = "uhome")
public class HomeController {
    @Autowired
    private SecUserService userService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "index")
    public String index(HttpServletRequest request){
        ProductVo productVo = new ProductVo();
        CommonVo commonVo = new CommonVo();
        LocalDateTime now = LocalDateTime.now();
        productVo.setStartTimeRangeFloor(now);
        productVo.setAuditState(1);
        commonVo.setProductVo(productVo);
        List<Product> products = productService.queryAll(commonVo);
        request.setAttribute("products", products);
        return "/uhome/index.jsp";
    }

//    @RequestMapping(value = "signup")
//    public String signUp(){
//        return "redirect:/sign/usignup";
//    }
//
//    @RequestMapping(value = "usignin")
//    public String uSignIn(){
//        return "redirect:/sign/usignin";
//    }
//
//    @RequestMapping(value = "signoff")
//    public String signOff(){
//        return "redirect:/sign/usignoff";
//    }
}
