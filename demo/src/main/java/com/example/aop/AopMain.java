package com.example.aop;

import com.example.aop.parameter.ParameterAop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopMain {
    
    public static void main(String[] args) {
        SpringApplication.run(AopMain.class, args);
    }
}
