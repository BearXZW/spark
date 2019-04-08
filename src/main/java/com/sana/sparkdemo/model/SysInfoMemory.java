package com.sana.sparkdemo.model;

import java.util.Date;

public class SysInfoMemory {
    private Integer id;

    private Date createtime;

    private String used;

    private String total;

    private String usedpercent;

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

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used == null ? null : used.trim();
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }

    public String getUsedpercent() {
        return usedpercent;
    }

    public void setUsedpercent(String usedpercent) {
        this.usedpercent = usedpercent == null ? null : usedpercent.trim();
    }
}