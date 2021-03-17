package com.yates.dao;

import com.yates.entity.Merchant;
import com.yates.vo.CustomVo;

import java.util.List;

public interface IMerchantDao {
    void insertMerchant(Merchant merchant);
    Merchant queryMerchantById(int id);
    void updateMerchant(Merchant merchant);
    void deleteMerchantById(int id);
    Merchant queryMerchantByAccount(String account);
    List<Merchant> queryMerchants(CustomVo customVo);

}