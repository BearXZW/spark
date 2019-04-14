package com.sana.sparkdemo.service;

import com.sana.sparkdemo.model.Userinfo;

import java.util.List;

public interface UserinfoService {

    int insert(Userinfo userinfo);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(Userinfo record);

    List<Userinfo> selectAllUserinfo(int pageNum, int pageSize);

    List<Userinfo> selectByName(String realname);

    Userinfo selectByPrimaryKey(Integer id);

    //批量删除用户
    int deleteBatch(List<Integer> ids);
    //获取用户数量
    int getNumofUser();
}
