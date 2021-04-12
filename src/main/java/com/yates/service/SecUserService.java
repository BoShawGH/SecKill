package com.yates.service;

import com.yates.dao.ISecUserDao;
import com.yates.entity.DataResult;
import com.yates.entity.SecUser;
import com.yates.vo.CommonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;

@Service
public class SecUserService {
    @Autowired
    public ISecUserDao iSecUserDao;


    public int checkUser(String userId){
        try {
            SecUser user = iSecUserDao.queryUserById(userId);
            if(user != null)
                return 1;
            else
                return 0;
        }catch (Exception ex){
            return 0;
        }
    }
    /**
     * 增添用户信息
     * @param secUser
     */
    public void insertUser(SecUser secUser){
        iSecUserDao.insertUser(secUser);
    }

    /**
     * 删除用户信息
     * @param userId
     */
    public void deleteUserById(String userId){
        iSecUserDao.deleteUserById(userId);
    }

    /**
     * 更新用户信息
     * @param secUser
     */
    public void updateUser(SecUser secUser){
        iSecUserDao.updateUser(secUser);
    }

    /**
     * 查找指定用户
     * @param userId
     * @return
     */
    public SecUser queryUserById(String userId){
        return iSecUserDao.queryUserById(userId);
    }

    public SecUser queryUserByAccount(String userAccount){
        return iSecUserDao.queryUserByAccount(userAccount);
    }

    /**
     * 查看所有用户信息
     * @param commonVo
     * @return
     */
    public List<SecUser> queryAll(CommonVo commonVo){
        return iSecUserDao.queryAll(commonVo);
    }

}
