package com.sana.sparkdemo.controller;


import com.sana.sparkdemo.service.FreqItemSetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Items")
public class ItemsController {

    @Autowired
    private FreqItemSetsService freqItemSetsService;

    @PostMapping("/getAllItems")
    public Object getAllItems(){
        return freqItemSetsService.getAllItems();
    }

}
