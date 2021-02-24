package com.yates.entity;

import javax.persistence.Column;

/**
 * 商家后台 商家实体
 */
public class Merchant {
    @Column
    private int id;
    private String merchantName;
    private String merchantAccount;
    private String merchantPassword;
    private String merchantScope;
    private String merchantShopname;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
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

    public String getMerchantShopname() {
        return merchantShopname;
    }

    public void setMerchantShopname(String merchantShopname) {
        this.merchantShopname = merchantShopname;
    }

    @Override
    public String toString() {
        return "Merchant [id=" + id + ", merchantAccount=" + merchantAccount + ", merchantName=" + merchantName
                + ", merchantPassword=" + merchantPassword + ", merchantScope=" + merchantScope + ", merchantShopname="
                + merchantShopname + "]";
    }


}