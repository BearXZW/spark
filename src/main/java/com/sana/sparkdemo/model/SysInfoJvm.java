package com.sana.sparkdemo.model;

import java.util.Date;

public class SysInfoJvm {
    private Integer id;

    private Date createtime;

    private String used;

    private String free;

    private String total;

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

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free == null ? null : free.trim();
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }
}