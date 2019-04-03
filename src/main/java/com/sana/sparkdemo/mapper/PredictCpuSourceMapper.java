package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.PredictCpuSource;

import java.util.List;

public interface PredictCpuSourceMapper {
    int deleteByPrimaryKey(Integer index);

    int insert(PredictCpuSource record);

    int insertSelective(PredictCpuSource record);

    PredictCpuSource selectByPrimaryKey(Integer index);

    int updateByPrimaryKeySelective(PredictCpuSource record);

    int updateByPrimaryKey(PredictCpuSource record);

//    获取所有的数据
    List<PredictCpuSource> getAll();
}