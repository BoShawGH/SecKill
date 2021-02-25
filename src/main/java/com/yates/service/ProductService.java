package com.yates.service;

import com.yates.dao.IProductDao;
import com.yates.entity.Product;
import com.yates.vo.CustomVo;
import com.yates.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    public IProductDao iProductDao;
    public DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 申请秒杀商品
     * @param product
     */
    public void applyProduct(Product product){
        product.setApplyDate(LocalDateTime.now());
        product.setApplyDateString(product.getApplyDate().format(dateTimeFormatter));
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

    /**
     * 通过id查询商品
     * @param id
     * @return
     */
    public Product queryProductById(int id){
        return iProductDao.queryProductById(id);
    }

    /**
     * 删除指定id商品
     * @param id
     */
    public void deleteProductById(int id){
        iProductDao.deleteProductById(id);
    }

    /**
     * 更新商品
     * @param product
     */
    public void updateProduct(Product product){
        iProductDao.updateProduct(product);
    }

    /**
     * 更新产品状态
     * @param id
     * @param state
     */
    public void updateProductState(int id, int state){
        CustomVo customVo = new CustomVo();
        ProductVo productVo = new ProductVo();
        productVo.setAuditState(state);
        productVo.setId(id);
        productVo.setAuditDate(LocalDateTime.now());
        productVo.setAuditDateString(productVo.getAuditDate().format(dateTimeFormatter));
        customVo.setProductVo(productVo);
        iProductDao.updateProductState(customVo);
    }
}
