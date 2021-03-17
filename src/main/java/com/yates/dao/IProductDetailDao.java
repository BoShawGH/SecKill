package com.yates.dao;

import com.yates.entity.Product;
import com.yates.entity.ProductDetail;
import com.yates.vo.CommonVo;

import java.util.List;

public interface IProductDetailDao {

    void insertProductDetail(ProductDetail productDetail);
    void deleteByProductId(String productId);
    void updateDetail(String productId);
    ProductDetail queryByProductId(String productId);
    List<ProductDetail> queryAll(CommonVo commonVo);
}
