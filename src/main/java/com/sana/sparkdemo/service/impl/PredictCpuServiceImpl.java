package com.sana.sparkdemo.service.impl;

import com.sana.sparkdemo.mapper.PredictCpuMapper;
import com.sana.sparkdemo.model.PredictCpu;
import com.sana.sparkdemo.service.PredictCpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="PredictCpuService")
public class PredictCpuServiceImpl implements PredictCpuService {

    @Autowired
    private PredictCpuMapper predictCpuMapper;
    @Override
    public List<PredictCpu> getAll(){
       return predictCpuMapper.getAll();
    }
}
