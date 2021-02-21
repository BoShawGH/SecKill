package com.yates.dao;

import com.yates.entity.Product;
import com.yates.vo.CustomVo;

import java.util.List;

public interface IProductDao {
     void applyProduct(Product product);
     void deleteProductById(int id);
     void updateProduct(Product product);
     Product queryProductById(int id);
     List<Product> queryProducts(CustomVo customVo);
     void updateProductState(CustomVo customVo);
}
