package com.yates.service;

import com.yates.dao.ISecUser;
import com.yates.entity.SecUser;
import com.yates.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecUserService {
    @Autowired
    public ISecUser iSecUser;

    /**
     * 增添用户信息
     * @param secUser
     */
    public void insertUser(SecUser secUser){
        iSecUser.insertUser(secUser);
    }

    /**
     * 删除用户信息
     * @param userId
     */
    public void deleteUserById(String userId){
        iSecUser.deleteUserById(userId);
    }

    /**
     * 更新用户信息
     * @param secUser
     */
    public void updateUser(SecUser secUser){
        iSecUser.updateUser(secUser);
    }

    /**
     * 查找指定用户
     * @param userId
     * @return
     */
    public SecUser queryUserById(String userId){
        return iSecUser.queryUserById(userId);
    }

    public SecUser queryUserByAccount(String userAccount){
        return iSecUser.queryUserByAccount(userAccount);
    }

    /**
     * 查看所有用户信息
     * @param commonVo
     * @return
     */
    public List<SecUser> queryAll(CommonVo commonVo){
        return iSecUser.queryAll(commonVo);
    }

}
