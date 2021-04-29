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
    private String payState; // 0：未支付 1 已支付 2 发起退款 3 退款成功
    private String receivingAddress="";
    private String receivingPhone="";
    private String receivingName="";
    private String payType;

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

    public String getReceivingPhone() {
        return receivingPhone;
    }

    public void setReceivingPhone(String recevingPhone) {
        this.receivingPhone = recevingPhone;
    }

    public String getReceivingName() {
        return receivingName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public void setReceivingName(String recevingName) {
        this.receivingName = recevingName;
    }
}
