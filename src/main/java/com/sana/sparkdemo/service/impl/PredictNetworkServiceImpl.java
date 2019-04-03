package com.sana.sparkdemo.service.impl;

import com.sana.sparkdemo.mapper.PredictNetworkMapper;
import com.sana.sparkdemo.model.PredictNetwork;
import com.sana.sparkdemo.service.PredictNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="PredictNetwork")
public class PredictNetworkServiceImpl implements PredictNetworkService {

    @Autowired
    private PredictNetworkMapper predictNetworkMapper;

    @Override
    public List<PredictNetwork> getAll(){
        return  predictNetworkMapper.getAll();
    }
}
