package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.SysInfoMemory;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SysInfoMemoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysInfoMemory record);

    int insertSelective(SysInfoMemory record);

    SysInfoMemory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysInfoMemory record);

    int updateByPrimaryKey(SysInfoMemory record);

    //  实现按实际查询数据
    List<SysInfoMemory> SelectByTime(@Param("param") Map<String, Date> params);
}