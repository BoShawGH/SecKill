package com.yates.service;

import com.yates.dao.IProductDao;
import com.yates.entity.Product;
import com.yates.vo.CustomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;
import java.util.List;

@Service
public class ProductService implements IProductDao{
    @Autowired
    public IProductDao iProductDao;
    public DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * 申请秒杀商品
     * @param product
     */
    public void applyProduct(Product product){
        product.setApplyDate(LocalDateTime.now());
        product.setAuditState(0);
        try {
            product.setStartTime(LocalDateTime.parse(product.getStartTimeString(), dateTimeFormatter));
            product.setEndTime(LocalDateTime.parse(product.getEndTimeString(), dateTimeFormatter));
        }catch(UnsupportedTemporalTypeException ex){
            System.out.println("输入的日期不合法");
            return;
        }
        iProductDao.applyProduct(product);
    }

    /**
     * 查看商品列表
     * @param customVo
     * @return
     */
    public List<Product> listProducts(CustomVo customVo){
        return iProductDao.listProducts(customVo);
    }
}
