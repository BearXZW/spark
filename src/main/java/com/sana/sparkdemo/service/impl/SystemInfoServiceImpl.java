package com.sana.sparkdemo.service.impl;

import com.sana.sparkdemo.mapper.SysInfoCpuMapper;
import com.sana.sparkdemo.mapper.SysInfoJvmMapper;
import com.sana.sparkdemo.mapper.SysInfoMemoryMapper;
import com.sana.sparkdemo.mapper.SysInfoNetworkMapper;
import com.sana.sparkdemo.model.SysInfoCpu;
import com.sana.sparkdemo.model.SysInfoJvm;
import com.sana.sparkdemo.model.SysInfoMemory;
import com.sana.sparkdemo.model.SysInfoNetwork;
import org.hyperic.sigar.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Component
public class SystemInfoServiceImpl {

    @Autowired
    private SysInfoCpuMapper sysInfoCpuMapper;
    @Autowired
    private SysInfoJvmMapper sysInfoJvmMapper;
    @Autowired
    private SysInfoMemoryMapper sysInfoMemoryMapper;
    @Autowired
    private SysInfoNetworkMapper sysInfoNetworkMapper;
    public SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    private SysInfoCpu sysInfoCpu=new SysInfoCpu();
    private SysInfoJvm sysInfoJvm=new SysInfoJvm();
    private SysInfoMemory sysInfoMemory=new SysInfoMemory();
    private SysInfoNetwork sysInfoNetwork=new SysInfoNetwork();
    @Scheduled(cron = "1/5 1-59 8-22 * * ? ")
    public void SysInfoCpuInsert() throws SigarException {
        Sigar sigar = new Sigar();
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpuList[] = sigar.getCpuPercList();
        for (int i = 0, len = infos.length; i < len; i++) {
            CpuInfo info = infos[i];
            CpuPerc cpu = cpuList[i];
            SysInfoCpu sysInfoCpu = new SysInfoCpu();
            sysInfoCpu.setCreatetime(new Date());
            //用户使用率
            sysInfoCpu.setUserusage(CpuPerc.format(cpu.getUser()));
            //总共的使用率
            sysInfoCpu.setCombindusage(CpuPerc.format(cpu.getCombined()));
            //系统的使用率
            sysInfoCpu.setSysusage(CpuPerc.format(cpu.getSys()));
            //是第几块cpu
            sysInfoCpu.setCount(Integer.toString(i));
            //System.out.println(sysInfoCpu.getCount());
            //将数据插入数据库
            sysInfoCpuMapper.insert(sysInfoCpu);
        }
    }
    @Scheduled(cron = "1/5 1-59 8-22 * * ? ")
    public void SysInfoJvmInsert() throws UnknownHostException{
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        sysInfoJvm.setCreatetime(new Date());
        //sysInfoJvm.setUsed();
        //插入已经使用的内存
        sysInfoJvm.setUsed(Double.toString(r.totalMemory()/(1024 * 1024L)-r.freeMemory()/(1024 * 1024L)));
        //插入剩余的内容
        sysInfoJvm.setFree(Double.toString(r.freeMemory()/(1024 * 1024L)));
        //插入所有的内存
        sysInfoJvm.setTotal(Double.toString(r.totalMemory()/(1024 * 1024L)));

        //将数据插入数据库
        sysInfoJvmMapper.insert(sysInfoJvm);
    }
    @Scheduled(cron = "1/5 1-59 8-22 * * ? ")
    public void SysInfoMemoryInsert() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        sysInfoMemory.setCreatetime(new Date());
        //插入全部的内存
        sysInfoMemory.setTotal(Double.toString(mem.getTotal() / (1024 * 1024L)));
        //插入已经使用的内存
        sysInfoMemory.setUsed(Double.toString(mem.getUsed() / (1024 * 1024L)));
        //插入内存使用率
        sysInfoMemory.setUsedpercent(Double.toString(mem.getUsedPercent()));
        //将数据插入数据库
        sysInfoMemoryMapper.insert(sysInfoMemory);

    }
    @Scheduled(cron = "1/5 1-59 8-22 * * ? ")
    public void SysInfoNetworkInsert() throws SigarException{
        Sigar sigar = new Sigar();
        String ifNames[] = sigar.getNetInterfaceList();
        for (int i = 0, len = ifNames.length; i < len; i++) {

            String name = ifNames[i];
            NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
            //System.out.println(ifconfig.getAddress());
            if((!(ifconfig.getAddress().equals("0.0.0.0")))&&(!(ifconfig.getAddress().equals("127.0.0.1")))){
                sysInfoNetwork.setAddress(ifconfig.getAddress());
                sysInfoNetwork.setCreatetime(new Date());
                NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
                //接收的总包裹数
                sysInfoNetwork.setRxtotal(Double.toString(ifstat.getRxPackets()));
                //发送的总包裹数
                sysInfoNetwork.setTxtotal(Double.toString(ifstat.getTxPackets()));
                sysInfoNetworkMapper.insert(sysInfoNetwork);
            }

        }
      //
    }
}


