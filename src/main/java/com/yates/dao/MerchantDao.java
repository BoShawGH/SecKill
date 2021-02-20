package com.yates.dao;

import com.yates.entity.Merchant;
import com.yates.vo.CustomVo;
import com.yates.vo.MerchantVo;

import java.util.List;

public interface MerchantDao {
    void insertMerchant(Merchant merchant);
    Merchant queryMerchantById(int id);
    void updateMerchant(Merchant merchant);
    void deleteMerchantById(int id);

    List<Merchant> queryMerchants(CustomVo customVo);

}