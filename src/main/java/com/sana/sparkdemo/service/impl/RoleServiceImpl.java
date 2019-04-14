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
    public int insertRole(Role role){
        return roleMapper.insertSelective(role);
    }
    @Override
    public List<Role> findAllRole(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return roleMapper.selectAllRole();
    }
    @Override
    public int updateRole(Role role){
        return roleMapper.updateByPrimaryKeySelective(role);
    }
    @Override
    public int deleteRole(Integer roleid){
        return roleMapper.deleteByPrimaryKey(roleid);
    }
    @Override
    public Role findRoleByRolename(Role role){
       return roleMapper.selectRoleByRolename(role);
    }
    @Override
    public Role findRoleByRoleid(Integer roleid){
        return roleMapper.selectRoleByRoleId(roleid);
    }

    @Override
    public int getRoleNum() { return roleMapper.getNumofRole(); }

    @Override
    public List<Role> getRoleByName(String rolename) { return roleMapper.getRoleByName(rolename); }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return roleMapper.deleteBatch(ids);
    }
}
