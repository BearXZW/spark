package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.PredictCpu;

import java.util.List;

public interface PredictCpuMapper {
    int deleteByPrimaryKey(Integer index);

    int insert(PredictCpu record);

    int insertSelective(PredictCpu record);

    PredictCpu selectByPrimaryKey(Integer index);

    int updateByPrimaryKeySelective(PredictCpu record);

    int updateByPrimaryKey(PredictCpu record);

    List<PredictCpu> getAll();
}