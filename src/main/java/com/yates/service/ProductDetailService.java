package com.yates.service;

import com.yates.dao.IProductDao;
import com.yates.dao.IProductDetailDao;
import com.yates.entity.ProductDetail;
import com.yates.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailService {
    @Autowired
    public IProductDetailDao iProductDetailDao;

    public  void insertProductDetail(ProductDetail productDetail){
        iProductDetailDao.insertProductDetail(productDetail);
    }
    public void deleteByProductId(String productId){
        iProductDetailDao.deleteByProductId(productId);
    }
    public void updateDetail(String productId){
        iProductDetailDao.updateDetail(productId);
    }
    public ProductDetail queryByProductId(String productId){
        return iProductDetailDao.queryByProductId(productId);
    }
    public List<ProductDetail> queryAll(CommonVo commonVo){
        return iProductDetailDao.queryAll(commonVo);
    }
}
