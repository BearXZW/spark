package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.Userinfo;

import java.util.List;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
    //列举所有的用户信息表
    List<Userinfo> selectAllUserinfo();
    //通过姓名查找
    List<Userinfo> selectByName(String realname);
    //通过id查找

    //批量删除
    int deleteBatch(List<Integer> ids);

    //获取数据库中用户的数量
    int getNumofUser();
}