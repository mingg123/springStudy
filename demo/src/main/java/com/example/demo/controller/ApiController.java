package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //RequestMapping URI를 지정해주는 Annotation

public class ApiController {


    @GetMapping("/hello2") //http:/localhost:9090/api/hello
    public String hello2() {
        return "hello spring boot23!";
    }

}
