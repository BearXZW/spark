package com.sana.sparkdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sana.sparkdemo.mapper.RoleMapper;
import com.sana.sparkdemo.model.Role;
import com.sana.sparkdemo.service.RoleService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@CrossOrigin
@RequestMapping(value="/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //增加角色
    @PostMapping("/addRole")
    public Object addrole(@RequestBody Role role){
        JSONObject jsonObject=new JSONObject();
        Role rolefromBase=roleService.findRoleByRolename(role);
        if(rolefromBase==null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            //对角色创建数据初始化
            Date date = new Date();
            role.setCreatetime(format.format(date));
            role.setRolestatus(1);
            role.setPermissions("1");
            role.setUpdatetime(format.format(date));
            roleService.insertRole(role);
            jsonObject.put("message","增加成功");
            jsonObject.put("code","200");
        }
        else{
            jsonObject.put("message","增加失败,该角色已经存在");
            jsonObject.put("code","400");
        }
        return jsonObject;
    }

    //列表表示所有角色
    @PostMapping("/all")
    public Object listAllRole(@RequestBody JSONObject jsonObject){
        String  Num=jsonObject.get("pageNum").toString();
        String  Size=jsonObject.get("pageSize").toString();
        Integer pageNum=Integer.parseInt(Num);
        Integer pageSize=Integer.parseInt(Size);
        return roleService.findAllRole(pageNum,pageSize);

    }

    //修改角色
    @PostMapping("/updateRole")
    public Object updateRole(@RequestBody Role role){
        JSONObject jsonObject=new JSONObject();
        Role rolefromBase=roleService.findRoleByRolename(role);
        if(rolefromBase==null){
            jsonObject.put("message","修改失败，该角色不存在");
            jsonObject.put("code","400");
        }
        else{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();
            rolefromBase.setUpdatetime(format.format(date));
            rolefromBase.setRolename(role.getRolename());
            rolefromBase.setRoledesc(role.getRoledesc());
            roleService.updateRole(rolefromBase);
            jsonObject.put("message","修改成功");
            jsonObject.put("code","200");
        }
        return jsonObject;
    }
    //删除角色
    @PostMapping("/deleteRole")
    public Object deleteRole(@RequestBody Role role){
        JSONObject jsonObject=new JSONObject();
        Role rolefromBase=roleService.findRoleByRoleid(role.getId());
        if(rolefromBase==null){
            jsonObject.put("message","删除失败，该角色不存在");
            jsonObject.put("code","400");
        }
        else{
            roleService.deleteRole(role.getId());
            jsonObject.put("message","删除成功");
            jsonObject.put("code","200");
        }
        return jsonObject;
    }
}
