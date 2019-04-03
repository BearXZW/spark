package com.sana.sparkdemo.model;

import java.util.Date;

public class PredictTimeSource {
    private Integer index;

    private Date producetime;

    private String tomcatRequestCount;

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

    public String getTomcatRequestCount() {
        return tomcatRequestCount;
    }

    public void setTomcatRequestCount(String tomcatRequestCount) {
        this.tomcatRequestCount = tomcatRequestCount == null ? null : tomcatRequestCount.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}