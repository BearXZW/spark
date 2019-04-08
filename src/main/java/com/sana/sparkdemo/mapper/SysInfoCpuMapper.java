package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.SysInfoCpu;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SysInfoCpuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysInfoCpu record);

    int insertSelective(SysInfoCpu record);

    SysInfoCpu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysInfoCpu record);

    int updateByPrimaryKey(SysInfoCpu record);

//  实现按实际查询数据
    List<SysInfoCpu> SelectByTime(@Param("param") Map<String, Date> params);
}