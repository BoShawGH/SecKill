package com.yates.entity;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product {
    @Column
    private int id;
    private int productId;
    private String productTitle;
    private String productPicture;
    private BigDecimal originPrice;
    private int merchantId;
    private LocalDateTime applyDate;
    private LocalDateTime auditDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String applyDateString = "";
    private String auditDateString = "";
    private String startTimeString = "";
    private String endTimeString = "";
    private int auditState = 0; //0：未审核 1：审核通过 2：审核不通过
    private String stateString = "";



    private BigDecimal secPrice;
    private int productCount;
    private int stockCount;
    private String description;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public BigDecimal getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(BigDecimal originPrice) {
        this.originPrice = originPrice;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public LocalDateTime getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(LocalDateTime applyDate) {
        this.applyDate = applyDate;
        this.setApplyDateString(applyDate.format(this.dateTimeFormatter));
    }

    public String getApplyDateString() {
        return applyDateString;
    }

    public void setApplyDateString(String applyDateString) {
        this.applyDateString = applyDateString;
    }

    public LocalDateTime getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(LocalDateTime auditDate) {
        this.auditDate = auditDate;
        this.setAuditDateString(auditDate.format(this.dateTimeFormatter));
    }

    public String getAuditDateString() {
        return auditDateString;
    }

    public void setAuditDateString(String auditDateString) {
        this.auditDateString = auditDateString;
    }

    public int getAuditState() {
        return auditState;
    }

    public void setAuditState(int auditState) {
        this.auditState = auditState;
        this.setStateString(auditState);
    }

    public String getStateString() {
        return stateString;
    }

    public void setStateString(int auditState) {
        String[] state = {"未审核","通过","未通过"};
        this.stateString = state[auditState];
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        this.setStartTimeString(startTime.format(dateTimeFormatter));
    }

    public String getStartTimeString() {
        return startTimeString;
    }

    public void setStartTimeString(String startTimeString) {
        this.startTimeString = startTimeString;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        this.setEndTimeString(endTime.format(dateTimeFormatter));
    }

    public String getEndTimeString() {
        return endTimeString;
    }

    public void setEndTimeString(String endTimeString) {
        this.endTimeString = endTimeString;
    }

    public BigDecimal getSecPrice() {
        return secPrice;
    }

    public void setSecPrice(BigDecimal secPrice) {
        this.secPrice = secPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", productPicture='" + productPicture + '\'' +
                ", originPrice=" + originPrice +
                ", merchantId=" + merchantId +
                ", applyDate=" + applyDate +
                ", auditDate=" + auditDate +
                ", auditState=" + auditState +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", secPrice=" + secPrice +
                ", productCount=" + productCount +
                ", stockCount=" + stockCount +
                ", description='" + description + '\'' +
                '}';
    }
}

