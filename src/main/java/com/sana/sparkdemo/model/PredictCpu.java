package com.sana.sparkdemo.model;

import java.util.Date;

public class PredictCpu {
    private Integer index;

    private Date producetime;

    private String systemCpuPctUsage;

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

    public String getSystemCpuPctUsage() {
        return systemCpuPctUsage;
    }

    public void setSystemCpuPctUsage(String systemCpuPctUsage) {
        this.systemCpuPctUsage = systemCpuPctUsage == null ? null : systemCpuPctUsage.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}