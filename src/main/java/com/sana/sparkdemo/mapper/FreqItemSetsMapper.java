package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.FreqItemSets;

import java.util.List;

public interface FreqItemSetsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FreqItemSets record);

    int insertSelective(FreqItemSets record);

    FreqItemSets selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FreqItemSets record);

    int updateByPrimaryKey(FreqItemSets record);

//  查询所有的数据
    List<FreqItemSets> getAllItems();
}