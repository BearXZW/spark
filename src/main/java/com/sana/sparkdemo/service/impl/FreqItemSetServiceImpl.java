package com.sana.sparkdemo.service.impl;


import com.sana.sparkdemo.mapper.FreqItemSetsMapper;
import com.sana.sparkdemo.model.FreqItemSets;
import com.sana.sparkdemo.service.FreqItemSetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="FreqItemSetService")
public class FreqItemSetServiceImpl implements FreqItemSetsService {


    @Autowired
    private FreqItemSetsMapper freqItemSetsMapper;

    @Override
    public List<FreqItemSets> getAllItems(){
        return freqItemSetsMapper.getAllItems();
    }


}
