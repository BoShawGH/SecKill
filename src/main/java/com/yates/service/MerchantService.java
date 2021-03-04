package com.yates.service;

import com.yates.dao.IMerchantDao;
import com.yates.entity.Merchant;

import com.yates.vo.CustomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService{
    @Autowired
    public IMerchantDao IMerchantDao;

    public Merchant queryMerchantById(int id){
        Merchant merchant = IMerchantDao.queryMerchantById(id);
        return merchant;
    }

    public void insertMerchant(Merchant merchant){
        IMerchantDao.insertMerchant(merchant);
    }

    public void deleteMerchantById(int id){
        IMerchantDao.deleteMerchantById(id);
    }

    public void updateMerchant(Merchant merchant){
        IMerchantDao.updateMerchant(merchant);
    }

    public List<Merchant> queryMerchants(CustomVo customVo){
        return IMerchantDao.queryMerchants(customVo);
    }

    public Merchant queryMerchantByAccount(String account){
        return IMerchantDao.queryMerchantByAccount(account);
    }
}