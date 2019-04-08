package com.sana.sparkdemo.mapper;


import com.sana.sparkdemo.model.SysInfoJvm;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SysInfoJvmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysInfoJvm record);

    int insertSelective(SysInfoJvm record);

    SysInfoJvm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysInfoJvm record);

    int updateByPrimaryKey(SysInfoJvm record);

    //  实现按实际查询数据
    List<SysInfoJvm> SelectByTime(@Param("param") Map<String, Date> params);
}