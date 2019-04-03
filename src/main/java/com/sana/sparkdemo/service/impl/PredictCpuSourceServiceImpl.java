package com.sana.sparkdemo.service.impl;

import com.sana.sparkdemo.mapper.PredictCpuSourceMapper;
import com.sana.sparkdemo.model.PredictCpuSource;
import com.sana.sparkdemo.service.PredictCpuService;
import com.sana.sparkdemo.service.PredictCpuSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="PredictCpuSourceService")
public class PredictCpuSourceServiceImpl implements PredictCpuSourceService {

    @Autowired
    private PredictCpuSourceMapper predictCpuSourceMapper;

    @Override
    public List<PredictCpuSource> getAll(){
        return predictCpuSourceMapper.getAll();
    }
}
