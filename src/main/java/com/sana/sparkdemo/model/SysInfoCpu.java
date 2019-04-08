package com.sana.sparkdemo.model;

import java.util.Date;

public class SysInfoCpu {
    private Integer id;

    private Date createtime;

    private String userusage;

    private String sysusage;

    private String combindusage;

    private String count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUserusage() {
        return userusage;
    }

    public void setUserusage(String userusage) {
        this.userusage = userusage == null ? null : userusage.trim();
    }

    public String getSysusage() {
        return sysusage;
    }

    public void setSysusage(String sysusage) {
        this.sysusage = sysusage == null ? null : sysusage.trim();
    }

    public String getCombindusage() {
        return combindusage;
    }

    public void setCombindusage(String combindusage) {
        this.combindusage = combindusage == null ? null : combindusage.trim();
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count == null ? null : count.trim();
    }
}