package com.sana.sparkdemo.service;

import com.sana.sparkdemo.model.Role;

import java.util.List;

public interface RoleService {

    //增加角色
    int insertRole(Role role);
    //角色列表显示
    List<Role> findAllRole(int pageNum, int pageSize);
    //修改角色
    int updateRole(Role role);
    //删除角色
    int deleteRole(Integer roleid);
    //获取角色
    Role findRoleByRolename(Role role);

    Role findRoleByRoleid(Integer roleid);
    //获取角色的数量
    int getRoleNum();

    //通过名字来获取数据
    List<Role> getRoleByName(String rolename);

    //批量删除
    int deleteBatch(List<Integer> ids);
}


