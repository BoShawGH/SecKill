package com.yates.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    private int id;
    private int productId;
    private int userId;
    private int merchantId;
    private BigDecimal payAmount;
    private int transQuantity;
    private LocalDateTime createTime;
    private LocalDateTime payTime;
    private int payState; // 0:未支付 1:已支付
    private String receivingAddress;
    private String receivingPhone;
    private String transSerial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransQuantity() {
        return transQuantity;
    }

    public void setTransQuantity(int transQuantity) {
        this.transQuantity = transQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
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

    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    public String getReceivingPhone() {
        return receivingPhone;
    }

    public void setReceivingPhone(String receivingPhone) {
        this.receivingPhone = receivingPhone;
    }

    public String getTransSerial() {
        return transSerial;
    }

    public void setTransSerial(String transSerial) {
        this.transSerial = transSerial;
    }
}
