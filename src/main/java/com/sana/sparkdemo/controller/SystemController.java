package com.sana.sparkdemo.controller;


import java.net.InetAddress;

import java.net.UnknownHostException;

import java.text.DecimalFormat;
import java.util.Map;

import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


import org.hyperic.sigar.*;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author anly
 *
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/SystemInfo")

public class SystemController {


    /**
     * 服务器信息
     */

    @RequestMapping(value = "/server")

    public Object serverInfo(HttpServletResponse response) {

        Properties props = System.getProperties();

        Map<String, String> map = System.getenv();

        JSONObject jsonObject = new JSONObject();

//        System.out.println(map);

        jsonObject.put("server.user.name", map.get("USERNAME")); //用户名

        jsonObject.put("server.computer.name", map.get("COMPUTERNAME")); //计算机名

        jsonObject.put("server.computer.domain", map.get("USERDOMAIN")); //计算机域名

        InetAddress addr = null;

        try {

            addr = InetAddress.getLocalHost();

            jsonObject.put("server.ip", addr.getHostAddress()); //本机ip

            jsonObject.put("server.host.name", addr.getHostName()); //本机主机名

            jsonObject.put("server.user.home", props.getProperty("user.home")); //用户的主目录

            jsonObject.put("server.user.dir", props.getProperty("user.dir")); //用户的当前工作目录

        } catch (Exception e) {

//            logger.error(e.getMessage());

        }

//        super.response2Client(response, jsonObject.toString());
        return jsonObject;
    }



    /**
     * 系统信息
     */

    @RequestMapping(value = "/system")

    public Object systemInfo(HttpServletResponse response) {

        OperatingSystem OS = OperatingSystem.getInstance();

        //System.out.print(OS);
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("os.name", OS.getVendorName().toString()); //操作系统名称

        jsonObject.put("os.arch", OS.getArch()); //内核构架

        jsonObject.put("os.description", OS.getDescription().toString()); //操作系统的描述

        jsonObject.put("os.version", OS.getVersion()); //操作系统的版本号

//        super.response2Client(response, jsonObject.toString());
        return jsonObject;

    }



    /**
     * CPU信息
     * @throws SigarException
     */

    @RequestMapping(value = "/cpu")

    public Object cpuInfo(HttpServletResponse response) throws SigarException {

        Sigar sigar = new Sigar();

        CpuInfo infos[] = sigar.getCpuInfoList();

        CpuPerc cpuList[] = sigar.getCpuPercList();

        JSONObject jsonObject = new JSONObject();

        JSONArray jsonArray = new JSONArray();


        for (int i = 0, len = infos.length; i < len; i++) {// 不管是单块CPU还是多CPU都适用

            CpuInfo info = infos[i];

            JSONObject jso = new JSONObject();

//            jso.put("mhz", info.getMhz()); //CPU的总量MHz
//
//            jso.put("company", info.getVendor()); //CPU的厂商
//
//            jso.put("model", info.getModel()); //CPU型号类别
//
//            jso.put("cache.size", info.getCacheSize()); // 缓冲缓存数量

            CpuPerc cpu = cpuList[i];

            jso.put("CpuCore", (i+1));//CPU的第几块核心

            jso.put("UserUsage", CpuPerc.format(cpu.getUser())); //CPU的用户使用率

            jso.put("SystemUsage", CpuPerc.format(cpu.getSys())); //CPU的系统使用率

//            jso.put("freq.wait", CpuPerc.format(cpu.getWait())); //CPU的当前等待率
//
//            jso.put("freq.nice", CpuPerc.format(cpu.getNice())); //CPU的当前错误率
//
//            jso.put("freq.idle", CpuPerc.format(cpu.getIdle())); //CPU的当前空闲率

            jso.put("TotalUsage", CpuPerc.format(cpu.getCombined())); //CPU总的使用率

            jsonArray.add(jso);



        }

        jsonObject.put("cpu", jsonArray);

//        super.response2Client(response, jsonObject.toString());
        return jsonObject;
    }



    /**
     * JVM信息
     * @throws UnknownHostException
     */

    @RequestMapping(value = "/jvm")

    public Object jvmInfo(HttpServletResponse response) throws UnknownHostException {

        Runtime r = Runtime.getRuntime();

        Properties props = System.getProperties();

        JSONObject jsonObject = new JSONObject();
        DecimalFormat df = new DecimalFormat("#.00");

        jsonObject.put("JvmTotal", df.format((double)r.totalMemory()/(1024 * 1024L))+"M"); //JVM可以使用的总内存

        jsonObject.put("JvmFree", df.format((double)r.freeMemory()/(1024 * 1024L))+"M"); //JVM可以使用的剩余内存

        jsonObject.put("JvmUsed", df.format((double)(r.totalMemory()-r.freeMemory())/(1024 * 1024L))+"M"); //JVM已经使用的内存大小

        // jsonObject.put("jvm.memory.used", r.usedMemory()/(1024*1024L));

//        jsonObject.put("jvm.processor.avaliable", r.availableProcessors()); //JVM可以使用的处理器个数
//
//        jsonObject.put("jvm.java.version", props.getProperty("java.version")); //Java的运行环境版本
//
//        jsonObject.put("jvm.java.vendor", props.getProperty("java.vendor")); //Java的运行环境供应商
//
//        jsonObject.put("jvm.java.home", props.getProperty("java.home")); //Java的安装路径
//
//        jsonObject.put("jvm.java.specification.version", props.getProperty("java.specification.version")); //Java运行时环境规范版本
//
//        jsonObject.put("jvm.java.class.path", props.getProperty("java.class.path")); //Java的类路径
//
//        jsonObject.put("jvm.java.library.path", props.getProperty("java.library.path")); //Java加载库时搜索的路径列表
//
//        jsonObject.put("jvm.java.io.tmpdir", props.getProperty("java.io.tmpdir")); //默认的临时文件路径
//
//        jsonObject.put("jvm.java.ext.dirs", props.getProperty("java.ext.dirs")); //扩展目录的路径

//        super.response2Client(response, jsonObject.toString());
        return jsonObject;
    }



    /**
     * 内存信息
     * @throws SigarException
     */

    @RequestMapping(value = "/memory")

    public Object memoryInfo(HttpServletResponse response) throws SigarException {

        Sigar sigar = new Sigar();

        Mem mem = sigar.getMem();

        JSONObject jsonObject = new JSONObject();
        DecimalFormat df = new DecimalFormat("#.00");
        //jsonObject.put("Memory",df.format((double)mem.getTotal() / (1024 * 1024 *1024L))+"G");
        jsonObject.put("MemoryTotal", df.format((double)mem.getTotal() / (1024 * 1024 *1024L))+"G");// 内存总量

        jsonObject.put("MemoryUsed", df.format((double)mem.getUsed() / (1024 * 1024 *1024L))+"G");// 当前内存使用量

        jsonObject.put("MemoryFree", df.format((double)mem.getFree() / (1024 * 1024 *1024L))+"G");// 当前内存剩余量

        Swap swap = sigar.getSwap();

        jsonObject.put("memory.swap.total", swap.getTotal() / (1024 * 1024L));// 交换区总量

        jsonObject.put("memory.swap.used", swap.getUsed() / (1024 * 1024L));// 当前交换区使用量

        jsonObject.put("memory.swap.free", swap.getFree() / (1024 * 1024L));// 当前交换区剩余量

//        super.response2Client(response, jsonObject.toString());
        return jsonObject;

    }



    /**
     * 磁盘文件信息
     * @throws SigarException
     */

    @RequestMapping(value = "/file")

    public Object fileSystemInfo(HttpServletResponse response) throws SigarException {

        Sigar sigar = new Sigar();

        FileSystem fslist[] = sigar.getFileSystemList();

        JSONObject jsonObject = new JSONObject();

        JSONArray jsonArray = new JSONArray();

        for (int i = 0, len = fslist.length; i < len; i++) {

            FileSystem fs = fslist[i];

            JSONObject jso = new JSONObject();

            jso.put("dev.name", fs.getDevName()); //分区盘符名称

            jso.put("dir.name", fs.getDirName()); //分区盘符名称

            jso.put("flags", fs.getFlags()); //分区盘符类型

            jso.put("sys.type.name", fs.getSysTypeName()); //文件系统类型

            jso.put("type.name", fs.getTypeName()); //分区盘符类型名

            jso.put("type", fs.getType()); //分区盘符文件系统类型

            FileSystemUsage usage = null;


            try {

                usage = sigar.getFileSystemUsage(fs.getDirName());

            } catch (Exception e) {

//                logger.error(e.getMessage());

            }


            if(usage == null) {

                continue;

            }


            switch (fs.getType()) {

                case 0: // TYPE_UNKNOWN ：未知

                    break;

                case 1: // TYPE_NONE

                    break;

                case 2: // TYPE_LOCAL_DISK : 本地硬盘


                    jso.put("usage.totle", usage.getTotal() / 1024); // 分区总大小

                    jso.put("usage.free", usage.getFree() / 1024); // 分区剩余大小

                    jso.put("usage.avail", usage.getAvail() / 1024); // 分区可用大小

                    jso.put("usage.used", usage.getUsed() / 1024); // 分区已经使用量

                    jso.put("usage.use.percent", usage.getUsePercent() * 100D); // 分区资源的利用率

                    break;

                case 3:// TYPE_NETWORK ：网络

                    break;

                case 4:// TYPE_RAM_DISK ：闪存

                    break;

                case 5:// TYPE_CDROM ：光驱

                    break;

                case 6:// TYPE_SWAP ：页面交换

                    break;

            }

            jso.put("disk.reads", usage.getDiskReads()); // 读出

            jso.put("disk.writes", usage.getDiskWrites()); // 写入

            jsonArray.add(jso);

        }

        jsonObject.put("file.system", jsonArray);

//        super.response2Client(response, jsonObject.toString());
        return jsonObject;
    }



    /**
     * 网络信息
     * @throws SigarException
     */

    @RequestMapping(value = "/net")

    public Object netInfo(HttpServletResponse response) throws SigarException {

        Sigar sigar = new Sigar();

        String ifNames[] = sigar.getNetInterfaceList();

        JSONObject jsonObject = new JSONObject();

        JSONArray jsonArray = new JSONArray();

        for (int i = 0, len = ifNames.length; i < len; i++) {

            String name = ifNames[i];

            JSONObject jso = new JSONObject();

            NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
            System.out.print(ifconfig);
            jso.put("name", name); // 网络设备名

            jso.put("address", ifconfig.getAddress()); // IP地址

            jso.put("mask", ifconfig.getNetmask()); // 子网掩码


            if ((ifconfig.getFlags() & 1L) <= 0L) {

//                logger.info("!IFF_UP...skipping getNetInterfaceStat");

                continue;

            }

            NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);

            jso.put("rx.packets", ifstat.getRxPackets());// 接收的总包裹数

            jso.put("tx.packets", ifstat.getTxPackets());// 发送的总包裹数

            jso.put("rx.bytes", ifstat.getRxBytes());// 接收到的总字节数

            jso.put("tx.bytes", ifstat.getTxBytes());// 发送的总字节数

            jso.put("rx.errors", ifstat.getRxErrors());// 接收到的错误包数

            jso.put("tx.errors", ifstat.getTxErrors());// 发送数据包时的错误数

            jso.put("rx.dropped", ifstat.getRxDropped());// 接收时丢弃的包数

            jso.put("tx.dropped", ifstat.getTxDropped());// 发送时丢弃的包数

            jsonArray.add(jso);

        }

        jsonObject.put("net", jsonArray);

//        super.response2Client(response, jsonObject.toString());
        return jsonObject;
    }



    /**
     * 以太网信息
     * @throws SigarException
     */

    @RequestMapping(value = "/ethernet")

    public Object ethernetInfo(HttpServletResponse response) throws SigarException {

        Sigar sigar = new Sigar();

        String[] ifaces = sigar.getNetInterfaceList();

        JSONObject jsonObject = new JSONObject();

        JSONArray jsonArray = new JSONArray();

        for (int i = 0, len = ifaces.length; i < len; i++) {

            NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);

            if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0 || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {

                continue;

            }

            JSONObject jso = new JSONObject();

            jso.put("address", cfg.getAddress());// IP地址

            jso.put("broad.cast", cfg.getBroadcast());// 网关广播地址

            jso.put("hwaddr", cfg.getHwaddr());// 网卡MAC地址

            jso.put("net.mask", cfg.getNetmask());// 子网掩码

            jso.put("description", cfg.getDescription());// 网卡描述信息

            jso.put("type", cfg.getType());// 网卡类型

            jsonArray.add(jso);

        }

        jsonObject.put("ethernet", jsonArray);

//        super.response2Client(response, jsonObject.toString());
        return jsonObject;
    }

    //返回前端需要的信息

    @RequestMapping(value = "/info")
    public Object SystemInfo(HttpServletResponse response) throws SigarException{

        JSONObject jsonObject=new JSONObject();
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();

            jsonObject.put("HostAddress", addr.getHostAddress()); //本机ip

            jsonObject.put("HostName", addr.getHostName()); //本机主机名
        }
        catch(Exception e){
        }
        Sigar sigar = new Sigar();
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpuList[] = sigar.getCpuPercList();
        jsonObject.put("CpuModel", infos[0].getModel()); //CPU型号类别
        jsonObject.put("CpuCore",infos.length);//cpu核心数

        //mem 获取内存信息
        Mem mem = sigar.getMem();
        DecimalFormat df = new DecimalFormat("#.00");
//        System.out.print(df.format(((double)mem.getTotal() / (1024 * 1024*1024L))));
//        System.out.print(df.format(mem.getUsed() / (1024 * 1024*1024L)));
        jsonObject.put("Memory",df.format((double)mem.getTotal() / (1024 * 1024 *1024L))+"G");//内存总容量

        //jvm内存信息
        Runtime r = Runtime.getRuntime();
        jsonObject.put("JvmMemory",df.format((double)r.totalMemory()/(1024 * 1024))+"M"); //JVM可以使用的总内存

        return jsonObject;
    }

}