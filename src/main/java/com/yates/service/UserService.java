package com.yates.service;

import com.yates.dao.IUserDao;
import com.yates.entity.User;
import com.yates.vo.CustomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserDao {
    @Autowired
    public IUserDao iUserDao;

    public void insertUser(User user){
        iUserDao.insertUser(user);
    }

    public void deleteUserById(int id){
        iUserDao.deleteUserById(id);
    }

    public void updateUser(User user){
        iUserDao.updateUser(user);
    }

    public User queryUserById(int id){
        return iUserDao.queryUserById(id);
    }

    public User queryByAccount(String account){
        return iUserDao.queryByAccount(account);
    }
    public List<User> queryUsers(CustomVo customVo){
        return iUserDao.queryUsers(customVo);
    }
}
