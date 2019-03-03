package com.sana.sparkdemo.service;


import com.sana.sparkdemo.model.User;

import java.util.List;

public interface UserService {

//    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

    User findUserById(int id);

    void insert(User user);
    //登录方法
//    MyResult login(User user);

    User selectByUser(User user);

    User selectByName(String username);

    //注册方法
    void register(User user);
    //重置密码
    void setpassword(User user);

    //修改用户

    int updateByPrimaryKey(User user);

    //删除用户
    int deleteByPrimaryKey(Integer userid);
}
