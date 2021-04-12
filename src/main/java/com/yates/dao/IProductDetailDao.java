package com.yates.dao;

import com.yates.entity.Product;
import com.yates.entity.ProductDetail;
import com.yates.vo.CommonVo;

import java.util.List;

public interface IProductDetailDao {

    void insertDetail(ProductDetail productDetail);
    void deleteByProductId(String productId);
    void updateDetail(ProductDetail detail);
    ProductDetail queryByProductId(String productId);
}
