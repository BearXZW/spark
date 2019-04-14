package com.sana.sparkdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sana.sparkdemo.mapper.RoleMapper;
import com.sana.sparkdemo.model.Role;
import com.sana.sparkdemo.model.Userinfo;
import com.sana.sparkdemo.service.RoleService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping(value="/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //增加角色
    @PostMapping("/addRole")
    public Object addrole(@RequestBody Map<String,Role> map){
        JSONObject jsonObject=new JSONObject();
        Role role=map.get("role");
        if(roleService.insertRole(role)==0){
            jsonObject.put("message","添加失败");
            jsonObject.put("code","400");
        }
        else{
            jsonObject.put("message","添加成功");
            jsonObject.put("code","200");
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
        Integer pageTotal=roleService.getRoleNum();
        JSONObject jso=new JSONObject();
        jso.put("pageTotal",pageTotal);
        List<Role> rolelist=roleService.findAllRole(pageNum,pageSize);
        jso.put("rolelist",rolelist);
        return jso;
    }

    //修改角色
    @PostMapping("/updateRole")
    public Object updateRole(@RequestBody Map<String,Role> map){

        JSONObject jsonObject=new JSONObject();
        Role role=map.get("role");
        Role rolefromBase=roleService.findRoleByRoleid(role.getId());
        if(rolefromBase==null){
            jsonObject.put("message","修改失败，该角色不存在");
            jsonObject.put("code","400");
        }
        else{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();
            rolefromBase.setCreatetime(role.getCreatetime());
            rolefromBase.setUpdatetime(role.getUpdatetime());
            rolefromBase.setRolename(role.getRolename());
            rolefromBase.setRoledesc(role.getRoledesc());
            rolefromBase.setRolestatus(role.getRolestatus());
            roleService.updateRole(rolefromBase);
            jsonObject.put("message","修改成功");
            jsonObject.put("code","200");
        }
        return jsonObject;
    }
    //删除角色
    @PostMapping("/deleteRole")
    public Object deleteRole(@RequestBody  Map<String, Role> map){
        Role role=map.get("role");
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

    //通过rolename来获取角色
    @PostMapping("/getRoleByName")
    public Object getRoleByName(@RequestBody Role role){
        String rolename=role.getRolename();
        JSONObject jsonObject=new JSONObject();
        List<Role> rolelist=roleService.getRoleByName(rolename);
        int result=rolelist.size();
        if(result==0){
            jsonObject.put("message","查询失败，该角色不存在");
            jsonObject.put("code","400");
            jsonObject.put("total",result);
        }
        else{
            jsonObject.put("message","查询成功");
            jsonObject.put("rolelist",rolelist);
            jsonObject.put("total",result);
        }
        return jsonObject;
    }
    //批量删除
    @PostMapping("/deleteBatch")
    public Object deleteBatch(@RequestBody Map<String,List<Integer> > map){
        List<Integer> ids=map.get("ids");
        JSONObject jsonObject=new JSONObject();
        Integer count=roleService.deleteBatch(ids);
        if(count<0){
            jsonObject.put("message","批量删除失败");
            jsonObject.put("code","400");
        }
        else{
            jsonObject.put("message","批量删除成功");
            jsonObject.put("code","200");
        }
        return jsonObject;
    }
}
