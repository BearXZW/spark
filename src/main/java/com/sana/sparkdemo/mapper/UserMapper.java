package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //添加列举所有的
    List<User> selectAllUser();
    //实现登录方法
    List<User> login(User user);

    //通过user查找
    User selectByUser(User user);

    //通过username查找
    User selectByName(String username);

    //实现注册方法
    void register(User user);

    //实现修改密码的功能
    void setpassword(User user);

}