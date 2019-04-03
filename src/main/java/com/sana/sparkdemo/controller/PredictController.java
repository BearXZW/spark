package com.sana.sparkdemo.controller;


import com.alibaba.fastjson.JSONObject;
import com.sana.sparkdemo.model.PredictCpuSource;
import com.sana.sparkdemo.model.PredictNetwork;
import com.sana.sparkdemo.model.PredictNetworkSource;
import com.sana.sparkdemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value="/predict")
public class PredictController {

    @Autowired
    private PredictCpuService predictCpuService;
    @Autowired
    private PredictCpuSourceService predictCpuSourceService;
    @Autowired
    private PredictNetworkService predictNetworkService;
    @Autowired
    private PredictNetworkSourceService predictNetworkSourceService;
    @Autowired
    private PredictTimeService predictTimeService;
    @Autowired
    private PredictTimeSourceService predictTimeSourceService;





//    接口编写

    //cpu预测数据显示
    @PostMapping("/cpu")
    public Object getAllcpu(){
        return predictCpuService.getAll();
    }

    //cpu原始数据显示
    @PostMapping("/cpusource")
    public Object getAllcpusource(){
        return predictCpuSourceService.getAll();
    }


    //network预测数据显示
    @PostMapping("/network")
    public Object getAllnetwork(){
        return predictNetworkService.getAll();
    }
    //network 获取原始数据
    @PostMapping("/networksource")
    public Object getAllnetworksource(){
        return predictNetworkSourceService.getAll();
    }

    //time预测数据
    @PostMapping("/time")
    public Object getAlltime(){
        return predictTimeService.getAll();
    }
    @PostMapping("/timesource")
    public Object getAlltimesource() {
        return predictTimeSourceService.getAll();
    }
}


