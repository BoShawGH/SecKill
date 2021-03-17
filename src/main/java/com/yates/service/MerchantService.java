package com.yates.service;

import com.yates.dao.IMerchantDao;
import com.yates.entity.Merchant;
import com.yates.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService{
    @Autowired
    public IMerchantDao iMerchantDao;
    public void insertMerchant(Merchant merchant){
        iMerchantDao.insertMerchant(merchant);
    }

    public void deleteMerchantById(String merchantId){
        iMerchantDao.deleteMerchantById(merchantId);
    }

    public void updateMerchant(Merchant merchant){
        iMerchantDao.updateMerchant(merchant);
    }

    public Merchant queryMerchantById(String merchantId){
        return iMerchantDao.queryMerchantById(merchantId);
    }

    public Merchant queryMerchantByAccount(String merchantAccount){
        return iMerchantDao.queryMerchantByAccount(merchantAccount);
    }

    public List<Merchant> queryAll(CommonVo commonVo){
        return iMerchantDao.queryAll(commonVo);
    }
}
