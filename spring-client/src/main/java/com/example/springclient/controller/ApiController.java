package com.example.springclient.controller;

import com.example.springclient.dto.UserResponse;
import com.example.springclient.service.RestTemplateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/springapi/client")
public class ApiController {

    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping("")
    public UserResponse getHello() {
        return restTemplateService.hello();
    }
}
