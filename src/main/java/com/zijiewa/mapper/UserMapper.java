package com.zijiewa.mapper;

import com.zijiewa.po.User;

public interface UserMapper {
    //根据用户ID查询用户信息
    public User findUserById(int id) throws Exception;

    public User findUserResultMapById(int id) throws Exception;

    //public void insertUser(User user) throws Exception;

    //public void deleteUser(int id) throws Exception;
}
