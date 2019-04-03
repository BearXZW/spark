package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.PredictNetworkSource;

import java.util.List;

public interface PredictNetworkSourceMapper {
    int deleteByPrimaryKey(Integer index);

    int insert(PredictNetworkSource record);

    int insertSelective(PredictNetworkSource record);

    PredictNetworkSource selectByPrimaryKey(Integer index);

    int updateByPrimaryKeySelective(PredictNetworkSource record);

    int updateByPrimaryKey(PredictNetworkSource record);

//  获取所有的数据
    List<PredictNetworkSource> getAll();
}