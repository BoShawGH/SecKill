package com.yates.service;

import com.yates.dao.IProductDao;
import com.yates.entity.Product;
import com.yates.vo.CustomVo;
import com.yates.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class ProductService{
    @Autowired
    public IProductDao iProductDao;

    /**
     * 申请产品
     * @param product
     */
    public void applyProduct(Product product){
        String startTime = product.getStartTimeString();
        String endTime = product.getEndTimeString();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try{
            LocalDateTime startTimeDate = LocalDateTime.parse(startTime, dateFormat);
            product.setStartTime(startTimeDate);
            LocalDateTime endTimeDate = LocalDateTime.parse(endTime, dateFormat);
            product.setEndTime(endTimeDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setApplyDate(LocalDateTime.now());
        product.setApplyDateString(dateFormat.format(product.getStartTime()));
        product.setAuditState(1);
        iProductDao.applyProduct(product);
    }

    /**
     * 通过id删除产品
     * @param id
     */
    public void deleteProductById(int id){
        iProductDao.deleteProductById(id);
    }

    /**
     * 更新产品信息
     * @param product
     */
    public void updateProduct(Product product){
        String startTime = product.getStartTimeString();
        String endTime = product.getEndTimeString();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try{
            LocalDateTime startTimeDate = LocalDateTime.parse(startTime, dateFormat);
            product.setStartTime(startTimeDate);
            LocalDateTime endTimeDate = LocalDateTime.parse(startTime, dateFormat);
            product.setEndTime(endTimeDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        iProductDao.updateProduct(product);
    }

    /**
     * 通过id查询产品信息
     * @param id
     * @return
     */
    public Product queryProductById(int id){
        return iProductDao.queryProductById(id);
    }

    /**
     * 查询全部产品信息
     * @param customVo
     * @return
     */
    public List<Product> queryProducts(CustomVo customVo){
        return iProductDao.queryProducts(customVo);
    }

    /**
     * 更新产品状态
     * @param id
     * @param state
     */
    public void updateProductState(int id, int state) {
        ProductVo productVo = new ProductVo();
        CustomVo customVo = new CustomVo();
        productVo.setId(id);
        productVo.setAuditState(state);
        productVo.setAuditDate(LocalDateTime.now());
        customVo.setProductVo(productVo);
        iProductDao.updateProductState(customVo);
    }
}
