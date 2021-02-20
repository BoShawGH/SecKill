package com.yates.dao;

import com.yates.entity.User;
import com.yates.vo.CustomVo;

import java.util.List;

public interface IUserDao {
    User queryUserById(int id);
    void deleteUserById(int id);
    void insertUser(User user);
    void updateUser(User user);

    List<User> queryUsers(CustomVo customVo);
}
