package com.yates.dao;

import com.yates.entity.ProductDetail;

public interface IProductDetailDao {
    void insertDetail(ProductDetail productDetail);
    ProductDetail queryById(int id);
    void updateDetail(ProductDetail productDetail);
}
