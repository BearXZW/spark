package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.PredictTimeSource;

import java.util.List;

public interface PredictTimeSourceMapper {
    int deleteByPrimaryKey(Integer index);

    int insert(PredictTimeSource record);

    int insertSelective(PredictTimeSource record);

    PredictTimeSource selectByPrimaryKey(Integer index);

    int updateByPrimaryKeySelective(PredictTimeSource record);

    int updateByPrimaryKey(PredictTimeSource record);

//  获取所有的数据
    List<PredictTimeSource> getAll();
}