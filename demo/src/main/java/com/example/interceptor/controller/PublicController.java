package com.example.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/public")
@Slf4j
public class PublicController {
    
    @GetMapping("/hello")
    public String hello() {
  
        return "public hello";
    }
}
