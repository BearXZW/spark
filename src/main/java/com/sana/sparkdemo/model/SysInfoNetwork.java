package com.sana.sparkdemo.model;

import java.util.Date;

public class SysInfoNetwork {
    private Integer id;

    private Date createtime;

    private String address;

    private String rxtotal;

    private String txtotal;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRxtotal() {
        return rxtotal;
    }

    public void setRxtotal(String rxtotal) {
        this.rxtotal = rxtotal == null ? null : rxtotal.trim();
    }

    public String getTxtotal() {
        return txtotal;
    }

    public void setTxtotal(String txtotal) {
        this.txtotal = txtotal == null ? null : txtotal.trim();
    }
}