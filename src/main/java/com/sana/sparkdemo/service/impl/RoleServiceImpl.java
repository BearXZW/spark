package com.sana.sparkdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.sana.sparkdemo.mapper.RoleMapper;
import com.sana.sparkdemo.model.Role;
import com.sana.sparkdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public void insertRole(Role role){
        roleMapper.insert(role);
    }
    @Override
    public List<Role> findAllRole(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return roleMapper.selectAllRole();
    }
    @Override
    public void updateRole(Role role){
        roleMapper.updateByPrimaryKey(role);
    }
    @Override
    public void deleteRole(Integer roleid){
        roleMapper.deleteByPrimaryKey(roleid);
    }
    @Override
    public Role findRoleByRolename(Role role){
       return roleMapper.selectRoleByRolename(role);
    }
    @Override
    public Role findRoleByRoleid(Integer roleid){
        return roleMapper.selectRoleByRoleId(roleid);
    }
}
