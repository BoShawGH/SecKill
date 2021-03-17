package com.yates.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    private String productId;
    private String merchantId;
    private String transSerial;
    private String userId;
    private BigDecimal payAmount;
    private int transQuantity;
    private LocalDateTime createTime;
    private LocalDateTime payTime;
    private String payState;
    private String receivingAddress;
    private String recevingPhone;
    private String recevingName;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTransSerial() {
        return transSerial;
    }

    public void setTransSerial(String transSerial) {
        this.transSerial = transSerial;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public int getTransQuantity() {
        return transQuantity;
    }

    public void setTransQuantity(int transQuantity) {
        this.transQuantity = transQuantity;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    public String getRecevingPhone() {
        return recevingPhone;
    }

    public void setRecevingPhone(String recevingPhone) {
        this.recevingPhone = recevingPhone;
    }

    public String getRecevingName() {
        return recevingName;
    }

    public void setRecevingName(String recevingName) {
        this.recevingName = recevingName;
    }
}
