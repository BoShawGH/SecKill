package com.yates.service;

import com.yates.dao.IProductDao;
import com.yates.entity.Product;
import com.yates.vo.CommonVo;
import com.yates.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductDao iProductDao;
    public void insertProduct(Product product){
        iProductDao.insertProduct(product);
    }

    public void deleteById(String productId){
        iProductDao.deleteById(productId);
    }

    public void updateProduct(Product product){
        iProductDao.updateProduct(product);
    }

    public void auditProduct(String productId, int auditState){
        CommonVo commonVo = new CommonVo();
        ProductVo productVo = new ProductVo();
        productVo.setAuditState(auditState);
        productVo.setProductId(productId);
        productVo.setAuditDate(LocalDateTime.now());
        commonVo.setProductVo(productVo);
        iProductDao.auditProduct(commonVo);
    }

    public Product queryProductById(String productId){
        return iProductDao.queryProductById(productId);
    }

    public List<Product> queryAll(CommonVo commonVo){
        return iProductDao.queryAll(commonVo);
    }
}
