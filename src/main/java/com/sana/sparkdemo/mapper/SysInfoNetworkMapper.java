package com.sana.sparkdemo.mapper;

import com.sana.sparkdemo.model.SysInfoMemory;
import com.sana.sparkdemo.model.SysInfoNetwork;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SysInfoNetworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysInfoNetwork record);

    int insertSelective(SysInfoNetwork record);

    SysInfoNetwork selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysInfoNetwork record);

    int updateByPrimaryKey(SysInfoNetwork record);

    //  实现按实际查询数据
    List<SysInfoNetwork> SelectByTime(@Param("param") Map<String, Date> params);
}