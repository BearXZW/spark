package com.sana.sparkdemo.model;

import java.util.Date;

public class PredictNetworkSource {
    private Integer index;

    private Date producetime;

    private String networkHttpResponseTime;

    private Integer type;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Date getProducetime() {
        return producetime;
    }

    public void setProducetime(Date producetime) {
        this.producetime = producetime;
    }

    public String getNetworkHttpResponseTime() {
        return networkHttpResponseTime;
    }

    public void setNetworkHttpResponseTime(String networkHttpResponseTime) {
        this.networkHttpResponseTime = networkHttpResponseTime == null ? null : networkHttpResponseTime.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}