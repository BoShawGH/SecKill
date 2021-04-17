package com.yates.dao;

import com.yates.entity.SecUser;
import com.yates.vo.CommonVo;

import java.util.List;

public interface ISecUserDao {
    void insertUser(SecUser secUser);
    void updateUser(SecUser secUser);
    void deleteUserById(String userId);
    SecUser queryUserById(String userId);
    SecUser queryUserByAccount(String userAccount);
    List<SecUser> queryAll(CommonVo commonVo);

}
