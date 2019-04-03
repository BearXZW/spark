package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.PredictNetwork;

import java.util.List;

public interface PredictNetworkMapper {
    int deleteByPrimaryKey(Integer index);

    int insert(PredictNetwork record);

    int insertSelective(PredictNetwork record);

    PredictNetwork selectByPrimaryKey(Integer index);

    int updateByPrimaryKeySelective(PredictNetwork record);

    int updateByPrimaryKey(PredictNetwork record);

//    获取所有数据
    List<PredictNetwork> getAll();
}