package com.sana.sparkdemo.service.impl;

import com.sana.sparkdemo.mapper.PredictTimeSourceMapper;
import com.sana.sparkdemo.model.PredictTime;
import com.sana.sparkdemo.model.PredictTimeSource;
import com.sana.sparkdemo.service.PredictTimeSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="PredictTimeSource")
public class PredictTimeSourceServiceImpl implements PredictTimeSourceService {

    @Autowired
    private PredictTimeSourceMapper predictTimeSourceMapper;
    @Override
    public List<PredictTimeSource> getAll(){
        return predictTimeSourceMapper.getAll();
    }
}
