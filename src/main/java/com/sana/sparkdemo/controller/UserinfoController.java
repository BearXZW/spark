package com.sana.sparkdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.sana.sparkdemo.model.User;
import com.sana.sparkdemo.model.Userinfo;
import com.sana.sparkdemo.service.UserService;
import com.sana.sparkdemo.service.UserinfoService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Ids;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/userinfo")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;
//    @Autowired
//    private UserService userService;

    //增加用户信息
    @PostMapping("/addUserinfo")
    public Object addUserinfo(@RequestBody Userinfo userinfo){
        JSONObject jsonObject=new JSONObject();
//        List<Userinfo> userinfoForBase=userinfoService.selectByName(userinfo.getRealname());
//        Userinfo userinfoForBase=userinfoService.selectByPrimaryKey(userinfo.getId());
//        if(userinfoForBase==null) {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
//            Date date = new Date();
        userinfo.setUserId(1);
        userinfo.setAge((Integer)countAge(userinfo.getBirthday()));
        userinfoService.insert(userinfo);
        List<Userinfo> userinfotemp=userinfoService.selectByName(userinfo.getRealname());
        if (userinfotemp == null) {
            jsonObject.put("message", "添加失败,插入数据库失败！");
            jsonObject.put("code", "400");
            return jsonObject;
        } else {
            jsonObject.put("message", "添加成功");
            jsonObject.put("code", "200");
            return jsonObject;
        }
//        }
//        else{
//            jsonObject.put("message", "添加失败,用户信息已存在");
//            jsonObject.put("code", "400");
//            return jsonObject;
//        }
    }
    //删除用户信息
    @PostMapping("/deleteUserinfo")
    public Object deleteUserinfo(@RequestBody Userinfo userinfo) {
        JSONObject jsonObject=new JSONObject();
//        List<Userinfo> userinfoForBase=userinfoService.selectByName(userinfo.getRealname());
        Userinfo userinfoForBase=userinfoService.selectByPrimaryKey(userinfo.getId());
        if(userinfoForBase==null) {
            jsonObject.put("message", "删除失败，该用户信息不存在！");
            jsonObject.put("code", "400");
            return jsonObject;
        }
        else {
            userinfoService.deleteByPrimaryKey(userinfo.getId());
            jsonObject.put("message", "删除成功");
            jsonObject.put("code", "200");
            return jsonObject;
        }
    }
    //修改用户信息
    @PostMapping("/updateUserinfo")
    public Object updateUserinfo(@RequestBody Userinfo userinfo) {
        JSONObject jsonObject=new JSONObject();
//        List<Userinfo> userinfoForBase=userinfoService.selectByName(userinfo.getRealname());
        Userinfo userinfoForBase=userinfoService.selectByPrimaryKey(userinfo.getId());
        if(userinfoForBase==null) {
            jsonObject.put("message", "修改失败，该用户信息不存在！");
            jsonObject.put("code", "400");
            return jsonObject;
        }
        else {
            userinfoService.updateByPrimaryKey(userinfo);
            jsonObject.put("message", "修改成功");
            jsonObject.put("code", "200");
            return jsonObject;
        }
    }
    //查找用户信息
    @PostMapping("/selectByName")
    public Object selectByName(@RequestBody Userinfo userinfo) {
        JSONObject jsonObject=new JSONObject();
        List<Userinfo> UserinfoResult=userinfoService.selectByName(userinfo.getRealname());
        if(UserinfoResult.size()==0) {
            jsonObject.put("message", "该用户信息不存在！");
            jsonObject.put("code", "400");
            return jsonObject;
        }
        else {
            jsonObject.put("message", "成功！");
            jsonObject.put("code", "200");
            jsonObject.put("userinfo",UserinfoResult);
            return jsonObject;
        }
    }
    //查找所有的信息
    @PostMapping("/all")
    public Object findAllUserinfo(@RequestBody JSONObject jsonObject){
        String Num=jsonObject.get("pageNum").toString();
        String Size=jsonObject.get("pageSize").toString();
        Integer pageNum=Integer.parseInt(Num);
        Integer pageSize=Integer.parseInt(Size);
        return  userinfoService.selectAllUserinfo(pageNum,pageSize);
    }
    //批量删除用户信息表
    @PostMapping("/deletebatch")
    public Object deletebatch(@RequestBody JSONObject ids){
        JSONObject jsonObject=new JSONObject();
        List<Integer> list=new ArrayList<Integer>();
        String[] stids=(ids.get("ids").toString()).split(",");
        for(int i=0;i<stids.length;i++){
            list.add(Integer.parseInt(stids[i]));
        }
        Integer count=userinfoService.deleteBatch(list);
        if(count<=0){
            jsonObject.put("message","批量删除失败！");
            jsonObject.put("code","400");
        }
        else{
            jsonObject.put("message","删除成功！");
            jsonObject.put("code","200");
        }
        return jsonObject;
    }
    //工具函数计算当前的年龄
    public int countAge(Date birthDay){
        Calendar cal=Calendar.getInstance();

        if(cal.before(birthDay)){
            throw new IllegalArgumentException("birthday time error");
        }
        int yearNow=cal.get(Calendar.YEAR);
        int monthNow=cal.get(Calendar.MONTH);
        int dayofMonthNow=cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth=cal.get(Calendar.YEAR);
        int monthBirth=cal.get(Calendar.MONTH);
        int dayofMonthBirth=cal.get(Calendar.DAY_OF_MONTH);

        int age=yearNow-yearBirth;
        if(monthNow<=monthBirth){
            if (monthNow == monthBirth) {
                if (dayofMonthNow < dayofMonthBirth) {
                    age--;
                }
            }
            else{
                age--;
            }
        }
        return age;
        }
}
