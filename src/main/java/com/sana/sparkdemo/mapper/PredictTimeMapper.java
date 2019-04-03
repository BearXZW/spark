package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.PredictTime;

import java.util.List;

public interface PredictTimeMapper {
    int deleteByPrimaryKey(Integer index);

    int insert(PredictTime record);

    int insertSelective(PredictTime record);

    PredictTime selectByPrimaryKey(Integer index);

    int updateByPrimaryKeySelective(PredictTime record);

    int updateByPrimaryKey(PredictTime record);

//    获取所有的数据
    List<PredictTime> getAll();

}