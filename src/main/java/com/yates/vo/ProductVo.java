package com.yates.vo;

import com.yates.entity.Product;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class ProductVo extends Product {

    private BigDecimal secPriceRangeFloor; // 秒杀价格查询下限
    private BigDecimal secPriceRangeCeil;  // 秒杀价格查询上限

    private BigDecimal originPriceRangeFloor;   // 原价格查询下限
    private BigDecimal originPriceRangeCeil;    // 原价格查询上限

    private LocalDateTime applyDateRangeFloor;  //申请时间查询下限
    private LocalDateTime applyDateRangeCeil;   //申请时间查询上限

    private LocalDateTime auditDateRangeFloor;  //审核时间查询下限
    private LocalDateTime auditDateRangeCeil;   //审核时间查询上限

    private LocalDateTime startTimeRangeFloor;  //秒杀开始时间查询下限
    private LocalDateTime startTimeRangeCeil;     //秒杀开始时间查询上限

    private LocalDateTime endTimeRangeFloor;  //秒杀结束时间查询下限
    private LocalDateTime endTimeRangeCeil;     //秒杀结束时间查询上限

    private int productCountRangeFloor;     //秒杀商品数查询下限
    private int productCountRangeCeil;      //秒杀商品数查询上限

    private int stockCountFloor;            //秒杀商品库存查询下限
    private int stockCountCeil;             //秒杀商品库存查询上限
    public BigDecimal getSecPriceRangeFloor() {
        return secPriceRangeFloor;
    }

    public void setSecPriceRangeFloor(BigDecimal secPriceRangeFloor) {
        this.secPriceRangeFloor = secPriceRangeFloor;
    }

    public BigDecimal getSecPriceRangeCeil() {
        return secPriceRangeCeil;
    }

    public void setSecPriceRangeCeil(BigDecimal secPriceRangeCeil) {
        this.secPriceRangeCeil = secPriceRangeCeil;
    }

    public BigDecimal getOriginPriceRangeFloor() {
        return originPriceRangeFloor;
    }

    public void setOriginPriceRangeFloor(BigDecimal originPriceRangeFloor) {
        this.originPriceRangeFloor = originPriceRangeFloor;
    }

    public BigDecimal getOriginPriceRangeCeil() {
        return originPriceRangeCeil;
    }

    public void setOriginPriceRangeCeil(BigDecimal originPriceRangeCeil) {
        this.originPriceRangeCeil = originPriceRangeCeil;
    }

    public LocalDateTime getApplyDateRangeFloor() {
        return applyDateRangeFloor;
    }

    public void setApplyDateRangeFloor(LocalDateTime applyDateRangeFloor) {
        this.applyDateRangeFloor = applyDateRangeFloor;
    }

    public LocalDateTime getApplyDateRangeCeil() {
        return applyDateRangeCeil;
    }

    public void setApplyDateRangeCeil(LocalDateTime applyDateRangeCeil) {
        this.applyDateRangeCeil = applyDateRangeCeil;
    }

    public LocalDateTime getAuditDateRangeFloor() {
        return auditDateRangeFloor;
    }

    public void setAuditDateRangeFloor(LocalDateTime auditDateRangeFloor) {
        this.auditDateRangeFloor = auditDateRangeFloor;
    }

    public LocalDateTime getAuditDateRangeCeil() {
        return auditDateRangeCeil;
    }

    public void setAuditDateRangeCeil(LocalDateTime auditDateRangeCeil) {
        this.auditDateRangeCeil = auditDateRangeCeil;
    }

    public LocalDateTime getStartTimeRangeFloor() {
        return startTimeRangeFloor;
    }

    public void setStartTimeRangeFloor(LocalDateTime startTimeRangeFloor) {
        this.startTimeRangeFloor = startTimeRangeFloor;
    }

    public LocalDateTime getStartTimeRangeCeil() {
        return startTimeRangeCeil;
    }

    public void setStartTimeRangeCeil(LocalDateTime startTimeRangeCeil) {
        this.startTimeRangeCeil = startTimeRangeCeil;
    }

    public LocalDateTime getEndTimeRangeFloor() {
        return endTimeRangeFloor;
    }

    public void setEndTimeRangeFloor(LocalDateTime endTimeRangeFloor) {
        this.endTimeRangeFloor = endTimeRangeFloor;
    }

    public LocalDateTime getEndTimeRangeCeil() {
        return endTimeRangeCeil;
    }

    public void setEndTimeRangeCeil(LocalDateTime endTimeRangeCeil) {
        this.endTimeRangeCeil = endTimeRangeCeil;
    }

    public int getProductCountRangeFloor() {
        return productCountRangeFloor;
    }

    public void setProductCountRangeFloor(int productCountRangeFloor) {
        this.productCountRangeFloor = productCountRangeFloor;
    }

    public int getProductCountRangeCeil() {
        return productCountRangeCeil;
    }

    public void setProductCountRangeCeil(int productCountRangeCeil) {
        this.productCountRangeCeil = productCountRangeCeil;
    }

    public int getStockCountFloor() {
        return stockCountFloor;
    }

    public void setStockCountFloor(int stockCountFloor) {
        this.stockCountFloor = stockCountFloor;
    }

    public int getStockCountCeil() {
        return stockCountCeil;
    }

    public void setStockCountCeil(int stockCountCeil) {
        this.stockCountCeil = stockCountCeil;
    }
}
