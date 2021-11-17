package com.example.apiExample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiexample")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot!";
    }

}
