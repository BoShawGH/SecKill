package com.yates.dao;

import com.yates.entity.Merchant;

public interface MerchantDao {
    void insertMerchant(Merchant merchant);
    Merchant queryMerchantById(int id);
    void updateMerchant(Merchant merchant);
    void deleteMerchantById(int id);
    
}