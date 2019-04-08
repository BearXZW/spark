package com.sana.sparkdemo.service.impl;

import com.sana.sparkdemo.mapper.SysInfoCpuMapper;
import com.sana.sparkdemo.mapper.SysInfoJvmMapper;
import com.sana.sparkdemo.mapper.SysInfoMemoryMapper;
import com.sana.sparkdemo.mapper.SysInfoNetworkMapper;
import com.sana.sparkdemo.model.SysInfoCpu;
import com.sana.sparkdemo.model.SysInfoJvm;
import com.sana.sparkdemo.model.SysInfoMemory;
import com.sana.sparkdemo.model.SysInfoNetwork;
import com.sana.sparkdemo.service.SysinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(value="SysinfoService")
public class SysinfoServiceImpl implements SysinfoService {

    @Autowired
    private SysInfoCpuMapper sysInfoCpuMapper;
    @Autowired
    private SysInfoJvmMapper sysInfoJvmMapper;
    @Autowired
    private SysInfoMemoryMapper sysInfoMemoryMapper;
    @Autowired
    private SysInfoNetworkMapper sysInfoNetworkMapper;

    @Override
    public List<SysInfoCpu> SelectCpuByTime(Map<String, Date> params) {
        return sysInfoCpuMapper.SelectByTime(params);
    }

    @Override
    public List<SysInfoJvm> SelectJvmByTime(Map<String, Date> params) {
        return  sysInfoJvmMapper.SelectByTime(params);
    }

    @Override
    public List<SysInfoMemory> SelectMemoryByTime(Map<String, Date> params) {
        return sysInfoMemoryMapper.SelectByTime(params);
    }

    @Override
    public List<SysInfoNetwork> SelectNetworkByTime(Map<String, Date> params) {
        return sysInfoNetworkMapper.SelectByTime(params);
    }


}
