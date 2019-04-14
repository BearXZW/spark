package com.sana.sparkdemo.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.sana.sparkdemo.mapper.UserinfoMapper;
import com.sana.sparkdemo.model.Userinfo;
import com.sana.sparkdemo.service.UserService;
import com.sana.sparkdemo.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="userinfoService")
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public int insert(Userinfo userinfo){
       return  userinfoMapper.insert(userinfo);
    }

    @Override
    public int deleteByPrimaryKey(Integer id){
        return userinfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Userinfo record){
        return userinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Userinfo> selectAllUserinfo(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return userinfoMapper.selectAllUserinfo();
    }

    @Override
    public List<Userinfo> selectByName(String realname){

        return userinfoMapper.selectByName(realname);
    }
    @Override
    public Userinfo selectByPrimaryKey(Integer id){

        return userinfoMapper.selectByPrimaryKey(id);
    }
    @Override
    public int deleteBatch(List<Integer> ids){
//        JSONObject js=new JSONObject();
//        List<Integer> list=new ArrayList<Integer>();
//        String[] stids=ids.split(",");
//        for(String value:stids){
//            list.add(Integer.parseInt(value));
//        }
//        Integer count=userinfoMapper.deleteBatch(list);
//        if(count<0){
//            js.put("message","批量删除失败");
//            jsonObject.put("code", "400");
//            return jsonObject;
//        }
        return userinfoMapper.deleteBatch(ids);
    }

    @Override
    public int getNumofUser() {
        return userinfoMapper.getNumofUser();
    }
}
