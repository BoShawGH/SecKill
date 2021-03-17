package com.yates.dao;

import com.yates.entity.Product;
import com.yates.vo.CommonVo;

import java.util.List;

public interface IProductDao {
    void insertProduct(Product product);
    void deleteById(String productId);
    void updateProduct(Product product);
    Product queryProductById(String productId);
    List<Product> queryAll(CommonVo commonVo);
}
