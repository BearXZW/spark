package com.sana.sparkdemo.service.impl;

import com.sana.sparkdemo.mapper.PredictTimeMapper;
import com.sana.sparkdemo.model.PredictTime;
import com.sana.sparkdemo.service.PredictTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="PredictTime")
public class PredictTimeServiceImpl implements PredictTimeService {

    @Autowired
    private PredictTimeMapper predictTimeMapper;

    @Override
    public List<PredictTime> getAll(){
        return predictTimeMapper.getAll();
    }
}
