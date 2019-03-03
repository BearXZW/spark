package com.sana.sparkdemo.service.impl;


import com.github.pagehelper.PageHelper;
import com.sana.sparkdemo.mapper.UserMapper;
import com.sana.sparkdemo.model.User;
import com.sana.sparkdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

//    @Override
//    public int addUser(User user){
//
//        return userMapper.insertSelective(user);
//    }
    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize){
        //将参数传给这个方法就可以实现物理分页
        PageHelper.startPage(pageNum,pageSize);
        return userMapper.selectAllUser();
    }
    @Override
    public User findUserById(int id){

        return userMapper.selectByPrimaryKey(id);
    }
//    @Override
//    public MyResult login(User user){
//        User u=new User();
//        List<User> list=new ArrayList<>();
//        list=userMapper.login(user);
//        MyResult result=new MyResult();
//        if(list.size()!=0){
//            result.setCode(200);
//            result.setMsg("登录成功！");
//            result.setList(list);
//            result.setObj(list.get(200));
//        }else{
//            result.setCode(400);
//            result.setMsg("登录失败！");
//        }
//        return result;
//    }

    @Override
    public User selectByUser(User user){

        return userMapper.selectByUser(user);
    }

    @Override
    public User selectByName(String username){

        return userMapper.selectByName(username);
    }
    @Override
    public void insert(User user){
         userMapper.insert(user);
    }

    @Override
    public void register(User user){
        userMapper.register(user);
    }

    @Override
    public void setpassword(User user){
        userMapper.setpassword(user);
    }
    @Override
    public  int  updateByPrimaryKey(User user){
        return userMapper.updateByPrimaryKey(user);
    }
    @Override
    public int deleteByPrimaryKey(Integer userid){
        return userMapper.deleteByPrimaryKey(userid);
    }
}
