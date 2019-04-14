package com.sana.sparkdemo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sana.sparkdemo.mapper.SysInfoMemoryMapper;
import com.sana.sparkdemo.model.SysInfoCpu;
import com.sana.sparkdemo.model.SysInfoJvm;
import com.sana.sparkdemo.model.SysInfoMemory;
import com.sana.sparkdemo.model.SysInfoNetwork;
import com.sana.sparkdemo.service.SysinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping(value="/sysinfo")
public class SysinfoController {

    @Autowired
    private SysinfoService sysinfoService;

    @PostMapping("/cpu")
    public Object getCpu(){
        String format="yyyy-MM-dd hh:mm:ss";
        Calendar nowtime = Calendar.getInstance();
        Calendar beforetime = Calendar.getInstance();
        beforetime.add(Calendar.MINUTE, -1);// 1分钟之前的时间
        Date startTime=beforetime.getTime();
        Date endTime=nowtime.getTime();
//        try {
//            startTime = new SimpleDateFormat(format).parse("2019-04-08 11:40:57");
//            endTime=new SimpleDateFormat(format).parse("2019-04-08 11:43:42");
//
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
        //Date endTime= new Date("2019-04-07 16:07:37");
        //Date startTime= new Date("2019-04-07 16:07:16");

        Map<String, Date> params = new HashMap<String, Date>();
        params.put("startTime", startTime );
        params.put("endTime", endTime );
        JSONObject jsonObject=new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<SysInfoCpu> list=new ArrayList<SysInfoCpu>();
        list=sysinfoService.SelectCpuByTime(params);

        List<Integer> cpucount=new ArrayList<Integer>();

        for(int i=0;i<list.size();i++){
            //System.out.println(cpucount.;
            if(cpucount.contains(Integer.parseInt(list.get(i).getCount()))){
                break;
            }
            else{
                cpucount.add(Integer.parseInt(list.get(i).getCount()));
            }
        }

        //System.out.print(cpucount.size());

        ArrayList<SysInfoCpu>[] cpulist=new ArrayList[cpucount.size()];
        for(int i=0;i<cpucount.size();i++){
            cpulist[i]=new ArrayList<SysInfoCpu>();
        }

        for(int i=0;i<list.size();i++){
         for(int j=0;j<cpucount.size();j++){
             if ((Integer.parseInt(list.get(i).getCount())==j)){
                 try{
                     cpulist[j].add(list.get(i));
                 }
                 catch (NullPointerException e){
                     System.out.print("空指针异常");
                 }
             }
         }
        }
        for(int i=0;i<cpucount.size();i++){
            JSONObject jso = new JSONObject();
            jso.put("cpu",cpulist[i]);
            jsonArray.add(jso);
        }
        jsonObject.put("cpulist",jsonArray);
        return jsonObject;
    }

    @PostMapping("/jvm")
    public Object  getjvm(){
        JSONObject jsonObject=new JSONObject();
        String format="yyyy-MM-dd hh:mm:ss";
        Calendar nowtime = Calendar.getInstance();
        Calendar beforetime = Calendar.getInstance();
        beforetime.add(Calendar.MINUTE, -1);// 1分钟之前的时间
        Date startTime=beforetime.getTime();
        Date endTime=nowtime.getTime();
//        Date startTime=new Date();
//        Date endTime=new Date();
//        try {
//            startTime = new SimpleDateFormat(format).parse("2019-04-08 11:40:57");
//            endTime=new SimpleDateFormat(format).parse("2019-04-08 11:44:12");
//
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
        Map<String, Date> params = new HashMap<String, Date>();
        params.put("startTime", startTime );
        params.put("endTime", endTime );

        List<SysInfoJvm> jvmlist=new ArrayList<SysInfoJvm>();
        jvmlist= sysinfoService.SelectJvmByTime(params);
        jsonObject.put("jvm",jvmlist);
        return jsonObject;
    }
    @PostMapping("/memory")
    public Object getmemory(){
        JSONObject jsonObject=new JSONObject();
        String format="yyyy-MM-dd hh:mm:ss";
        Calendar nowtime = Calendar.getInstance();
        Calendar beforetime = Calendar.getInstance();
        beforetime.add(Calendar.MINUTE, -1);// 1分钟之前的时间
        Date startTime=beforetime.getTime();
        Date endTime=nowtime.getTime();
//        Date startTime=new Date();
//        Date endTime=new Date();
//        try {
//            startTime = new SimpleDateFormat(format).parse("2019-04-08 11:40:57");
//            endTime=new SimpleDateFormat(format).parse("2019-04-08 11:44:12");
//
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
        Map<String, Date> params = new HashMap<String, Date>();
        params.put("startTime", startTime );
        params.put("endTime", endTime );

        List<SysInfoMemory> memorylist=new ArrayList<SysInfoMemory>();
        memorylist=sysinfoService.SelectMemoryByTime(params);
        jsonObject.put("memory",memorylist);
        return jsonObject;
    }
    @PostMapping("/network")
    public Object getnetwork(){
        JSONObject jsonObject=new JSONObject();
        String format="yyyy-MM-dd hh:mm:ss";
        Calendar nowtime = Calendar.getInstance();
        Calendar beforetime = Calendar.getInstance();
        beforetime.add(Calendar.MINUTE, -1);// 1分钟之前的时间
        Date startTime=beforetime.getTime();
        Date endTime=nowtime.getTime();
//        Date startTime=new Date();
//        Date endTime=new Date();
//        try {
//            startTime = new SimpleDateFormat(format).parse("2019-04-08 11:40:57");
//            endTime=new SimpleDateFormat(format).parse("2019-04-08 11:44:12");
//
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
        Map<String, Date> params = new HashMap<String, Date>();
        params.put("startTime", startTime );
        params.put("endTime", endTime );
        List<SysInfoNetwork> networklist=new ArrayList<SysInfoNetwork>();
        networklist=sysinfoService.SelectNetworkByTime(params);
        jsonObject.put("network",networklist);
        return jsonObject;
    }
}
