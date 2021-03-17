package com.yates.service;

import com.yates.dao.IProductDetailDao;
import com.yates.entity.Product;
import com.yates.entity.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailService {
    @Autowired
    private IProductDetailDao iProductDetailDao;

    /**
     * 增加商品详情
     * @param productDetail
     */
    public void insertDetail(ProductDetail productDetail){
        iProductDetailDao.insertDetail(productDetail);
    }

    /**
     * 更新商品详情
     * @param productDetail
     */
    public void updateDetail(ProductDetail productDetail){
        iProductDetailDao.updateDetail(productDetail);
    }

    /**
     * 查询商品详情
     * @param id
     * @return
     */
    public ProductDetail queryById(int id){
        return iProductDetailDao.queryById(id);
    }
}
