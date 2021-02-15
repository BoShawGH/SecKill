package com.yates.entity;

/**
 * 商家后台 商家实体
 */
public class Merchant {
    private int id;
    private String merchantName;
    private String merchantAccount;
    private String merchantPassword;
    private String merchantScope;
    private String merchantShopname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

   public static class MerchantBuilder{
    private int id;
    private String merchantName;
    private String merchantAccount;
    private String merchantPassword;
    private String merchantScope;
    private String merchantShopname;
    private Merchant merchant = new Merchant();

    public MerchantBuilder setMerchantName(String name){
        merchant.setMerchantName(name);
        return this;
    }
    public MerchantBuilder setMerchantAccount(String account){
        merchant.setMerchantAccount(account);
        return this;
    }
    public MerchantBuilder setMerchantPassword(String password){
        merchant.setMerchantPassword(password);
        return this;
    }
    public MerchantBuilder setMerchantScope(String scope){
        merchant.setMerchantScope(scope);
        return this;
    }
    public MerchantBuilder setMerchantShopname(String shopname){
        merchant.setMerchantShopname(shopname);
        return this;
    }

    public Merchant build(){
        return merchant;
    }
   }

}