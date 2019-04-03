package com.sana.sparkdemo.controller;


import com.sana.sparkdemo.model.AssociationRules;
import com.sana.sparkdemo.service.AssociationRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Rules")
public class RulesController {

    @Autowired
    private AssociationRulesService associationRulesService;

    @PostMapping("/getAllRules")
    public Object getAllRules(){
        return  associationRulesService.getAllRules();
    }
}
