package com.yates.service;

import com.yates.dao.MerchantDao;
import com.yates.entity.Merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService implements MerchantDao {
    @Autowired
    public MerchantDao merchantDao;

    public Merchant queryMerchantById(int id){
        return merchantDao.queryMerchantById(id);
    }

    public void insertMerchant(Merchant merchant){
        merchantDao.insertMerchant(merchant);
    }

    public void deleteMerchantById(int id){
        merchantDao.deleteMerchantById(id);
    }

    public void updateMerchant(Merchant merchant){
        merchantDao.updateMerchant(merchant);
    }
}