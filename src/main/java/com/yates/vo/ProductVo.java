package com.yates.vo;

import com.yates.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductVo extends Product {
    public BigDecimal secPriceRangeFloor;       //秒杀价格下限
    public BigDecimal secPriceRangeCeil;        //秒杀价格上限
    public BigDecimal originPriceRangeFloor;    //原价格格下限
    public BigDecimal originPriceRangeCeil;     //原价格上限
    public LocalDateTime applyDateRangeFloor;   //申请时间下限
    public LocalDateTime applyDateRangeCeil;    //申请时间上限
    public LocalDateTime auditDateRangeFloor;   //审核时间下限
    public LocalDateTime auditDateRangeCeil;    //审核时间上限
    public LocalDateTime startTimeRangeFloor;   //开始时间下限
    public LocalDateTime startTimeRangeCeil;    //开始时间上限
    public LocalDateTime endTimeRangeFloor;     //结束时间下限
    public LocalDateTime endTimeRangeCeil;      //开始时间上限
    public int productCountRangeFloor;          //产品数量下限
    public int productCountRangeCeil;           //产品数量上限
    public int stockCountFloor;                 //库存数量下限
    public int stockCountCeil;                  //库存数量上限

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
