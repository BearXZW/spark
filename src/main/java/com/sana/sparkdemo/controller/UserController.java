package com.sana.sparkdemo.controller;


import com.alibaba.fastjson.JSONObject;
import com.sana.sparkdemo.annotation.UserLoginToken;
import com.sana.sparkdemo.model.User;
import com.sana.sparkdemo.service.TokenService;
import com.sana.sparkdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@CrossOrigin
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    //注册token服务
    private TokenService tokenService;
    //登录功能
    @PostMapping("/Login")
    public Object login(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.selectByUser(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败，用户不存在");
            jsonObject.put("code","400");
            return jsonObject;
        }
        else{
            if(!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败，密码错误");
                jsonObject.put("code","400");
                return jsonObject;
            }
            else{
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                jsonObject.put("code","200");
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public  String getMessage(){
        return "你已经通过验证";
    }

    //注册功能
    @PostMapping("/register")
    public  Object register(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.selectByUser(user);
        if(userForBase==null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();
            user.setRegTime(format.format(date));
            user.setRoleid(2);
            user.setUserStatus(1);
            userService.insert(user);
            jsonObject.put("message","注册成功");
            jsonObject.put("code","200");
        }else{
            jsonObject.put("message","注册失败，用户名已存在");
            jsonObject.put("code","400");
        }
        return jsonObject;
    }
//    @RequestMapping("/index")
//    public String index(Model model, User user) {
//
//        return "index";
//    }
    //修改密码
    @PostMapping("/SetPassword")
    public  Object setpassword(@RequestBody User user) {
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.selectByUser(user);
        if(userForBase==null){
            jsonObject.put("message","修改失败，用户不存在");
            jsonObject.put("code","400");
            return jsonObject;
        }
        else{
            if(!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","修改失败，原密码错误");
                jsonObject.put("code","400");
                return jsonObject;
            }
            else{
                user.setPassword(user.getRepassword());
                userService.setpassword(user);
                jsonObject.put("message","修改成功");
                jsonObject.put("code","200");
                return jsonObject;
            }
        }
    }

    //添加用户
    @PostMapping("/addUser")
    public  Object adduser(@RequestBody User user) {
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.selectByUser(user);
        if(userForBase==null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();
            user.setRegTime(format.format(date));
            user.setRoleid(2);
            user.setUserStatus(1);
            userService.insert(user);
            User usertemp = userService.selectByUser(user);
            if (usertemp == null) {
                jsonObject.put("message", "添加失败,插入数据库失败！");
                jsonObject.put("code", "400");
                return jsonObject;
            } else {
                jsonObject.put("message", "添加成功");
                jsonObject.put("code", "200");
                return jsonObject;
            }
        }
        else{
            jsonObject.put("message", "添加失败,用户已存在");
            jsonObject.put("code", "400");
            return jsonObject;
        }
    }

    //修改用户
    @PostMapping("/updateUser")
    public Object updateuser(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.selectByUser(user);
        if(userForBase==null){
            jsonObject.put("message","修改失败，用户不存在");
            jsonObject.put("code","400");
            return jsonObject;
        }
        else{
            userForBase.setUsername(user.getUsername());
            userForBase.setPassword(user.getPassword());
            userForBase.setPhone(user.getPhone());
            userForBase.setRoleid(user.getRoleid());
            userService.updateByPrimaryKey(userForBase);
            jsonObject.put("message","修改成功");
            jsonObject.put("code","200");
            return jsonObject;
        }
    }
    //删除用户
    @PostMapping("/deleteUser")
    public Object deleteuser(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findUserById(user.getUserid());
        if(userForBase==null){
            jsonObject.put("message","删除失败，用户不存在");
            jsonObject.put("code","400");
            return jsonObject;
        }
        else{
            userService.deleteByPrimaryKey(user.getUserid());
            jsonObject.put("message","删除成功");
            jsonObject.put("code","200");
            return jsonObject;
        }
    }
    @ResponseBody
    @RequestMapping(value="/test")
    public Object showUser(User user){
        return userService.findUserById(1);
    }
    @ResponseBody
    @RequestMapping(value="/add",produces = {"application/json;charset=UTF-8"})
    public void addUser(User user){
         userService.insert(user);
    }

    //用户列表显示
    //用户列表显示
//    @ResponseBody
//    @RequestMapping(value="/all/{pageNum}/{pageSize}",produces = {"application/json;charset=UTF-8"})
//    public Object findAllUser(@PathVariable("pageNum")int pageNum,@PathVariable("pageSize") int pageSize){
//        return userService.findAllUser(pageNum,pageSize);
//    }

//    //用户列表显示
    @PostMapping("/all")
    public Object findAllUser(@RequestBody JSONObject jsonObject){
        String Num=jsonObject.get("pageNum").toString();
        String Size=jsonObject.get("pageSize").toString();
        Integer pageNum=Integer.parseInt(Num);
        Integer pageSize=Integer.parseInt(Size);
        return userService.findAllUser(pageNum,pageSize);
    }
}
