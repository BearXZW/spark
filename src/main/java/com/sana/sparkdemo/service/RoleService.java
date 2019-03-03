package com.sana.sparkdemo.service;

import com.sana.sparkdemo.model.Role;

import java.util.List;

public interface RoleService {

    //增加角色
    void insertRole(Role role);
    //角色列表显示
    List<Role> findAllRole(int pageNum, int pageSize);
    //修改角色
    void updateRole(Role role);
    //删除角色
    void deleteRole(Integer roleid);
    //获取角色
    Role findRoleByRolename(Role role);

    Role findRoleByRoleid(Integer roleid);
}


