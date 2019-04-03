package com.sana.sparkdemo.service.impl;

import com.sana.sparkdemo.mapper.AssociationRulesMapper;
import com.sana.sparkdemo.model.AssociationRules;
import com.sana.sparkdemo.service.AssociationRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="AssociationRulesService")
public class AssociationRulesServiceImpl implements AssociationRulesService {

    @Autowired
    private AssociationRulesMapper associationRulesMapper;

    @Override
    public List<AssociationRules> getAllRules(){
        return associationRulesMapper.getAllRules();
    }
}
