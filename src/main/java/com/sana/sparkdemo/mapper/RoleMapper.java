package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    //列表显示所有角色
    List<Role> selectAllRole();

    //通过rolename获取角色

    Role selectRoleByRolename(Role role);

    Role selectRoleByRoleId(Integer roleid);
}