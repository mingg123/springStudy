package com.example.springfilter.controller;

import com.example.springfilter.annotation.Auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/interceptorapi/private")
@Auth
public class PrivateController {

    // http://localhost:9090/interceptorapi/private/hello?name=minji
    @GetMapping("/hello")
    public String hello() {
        log.info("private hello controller");
        return "private hello";
    }
}
