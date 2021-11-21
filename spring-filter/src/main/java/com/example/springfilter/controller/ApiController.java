package com.example.springfilter.controller;

import com.example.springfilter.dto.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/filterapi")
public class ApiController {

    @PostMapping("")
    public User user(@RequestBody User user) {
        log.info("User : {}, {}" + user.toString(), user, user);
        return user;
    }
}
