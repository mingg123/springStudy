package com.example.Filter.controller;

import com.example.Filter.dto.FilterUser;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;


@Slf4j
@RestController
@RequestMapping("/api/filteruser")
public class FilterApiController {
    
    @PostMapping("/post")
    public FilterUser user(@RequestBody FilterUser user) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("User : {}", user);
        return user;
    }
}
