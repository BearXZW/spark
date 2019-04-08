package com.sana.sparkdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.sana.sparkdemo.mapper")
@EnableScheduling
public class SparkdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkdemoApplication.class, args);
    }

}
