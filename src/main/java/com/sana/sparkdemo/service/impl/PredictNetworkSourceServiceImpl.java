package com.sana.sparkdemo.service.impl;

import com.sana.sparkdemo.mapper.PredictNetworkSourceMapper;
import com.sana.sparkdemo.model.PredictNetworkSource;
import com.sana.sparkdemo.service.PredictNetworkSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="PredictNetworkSource")
public class PredictNetworkSourceServiceImpl implements PredictNetworkSourceService {

    @Autowired
    private PredictNetworkSourceMapper predictNetworkSourceMapper;

    @Override
    public List<PredictNetworkSource> getAll(){
        return predictNetworkSourceMapper.getAll();
    }
}
