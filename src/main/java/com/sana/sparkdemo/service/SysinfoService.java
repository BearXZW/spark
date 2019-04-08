package com.sana.sparkdemo.service;

import com.sana.sparkdemo.model.SysInfoCpu;
import com.sana.sparkdemo.model.SysInfoJvm;
import com.sana.sparkdemo.model.SysInfoMemory;
import com.sana.sparkdemo.model.SysInfoNetwork;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SysinfoService {

    //获取cpu数据
    public List<SysInfoCpu> SelectCpuByTime(Map<String, Date> params);
    //获取jvm数据
    public List<SysInfoJvm> SelectJvmByTime(Map<String,Date> params);
    //获取内存数据
    public List<SysInfoMemory> SelectMemoryByTime(Map<String,Date> params);
    //获取网络数据
    public List<SysInfoNetwork> SelectNetworkByTime(Map<String,Date> params);



}
