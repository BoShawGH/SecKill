package com.yates.dao;

import com.yates.entity.Product;
import com.yates.vo.CustomVo;

import java.util.List;

public interface IProductDao {
     void applyProduct(Product product);

     List<Product> listProducts(CustomVo vo);
}
