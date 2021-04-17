package com.yates.entity;

public class Merchant {
    private String merchantId;
    private String merchantName;
    private String merchantShopname;
    private String merchantAccount;
    private String merchantPassword;
    private String merchantScope;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantShopname() {
        return merchantShopname;
    }

    public void setMerchantShopname(String merchantShopname) {
        this.merchantShopname = merchantShopname;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }

    public String getMerchantScope() {
        return merchantScope;
    }

    public void setMerchantScope(String merchantScope) {
        this.merchantScope = merchantScope;
    }
}
