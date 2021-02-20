package com.yates.vo;

import com.yates.entity.User;

public class CustomVo {
    private MerchantVo merchantVo;
    private UserVo userVo;

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public MerchantVo getMerchantVo() {
        return merchantVo;
    }

    public void setMerchantVo(MerchantVo merchantVo) {
        this.merchantVo = merchantVo;
    }
}
