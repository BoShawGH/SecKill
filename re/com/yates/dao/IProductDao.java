package com.yates.dao;

import com.yates.entity.Product;
import com.yates.vo.CustomVo;

import java.util.List;

public interface IProductDao {
     void applyProduct(Product product);
     Product queryProductById(int id);
     List<Product> listProducts(CustomVo vo);
     void deleteProductById(int id);
     void updateProduct(Product product);
     void updateProductState(CustomVo customVo);

}
