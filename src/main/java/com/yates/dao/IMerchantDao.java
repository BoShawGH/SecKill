package com.yates.dao;

import com.yates.entity.Merchant;
import com.yates.vo.CommonVo;

import java.util.List;

public interface IMerchantDao {
    void insertMerchant(Merchant merchant);
    void deleteMerchantById(String merchantId);
    void updateMerchant(Merchant merchant);
    Merchant queryMerchantById(String merchantId);
    Merchant queryMerchantByAccount(String merchantAccount);
    List<Merchant> queryAll(CommonVo commonVo);
}
