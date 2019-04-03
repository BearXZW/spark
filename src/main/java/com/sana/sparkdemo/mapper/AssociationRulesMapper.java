package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.AssociationRules;

import java.util.List;

public interface AssociationRulesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AssociationRules record);

    int insertSelective(AssociationRules record);

    AssociationRules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AssociationRules record);

    int updateByPrimaryKey(AssociationRules record);

//    查询所有的数据
    List<AssociationRules> getAllRules();
}