package com.example.apiExample.controller;

import com.example.apiExample.dto.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responseapiexample")
public class ResponseApiController {

    // http://localhost:9090/responseapiexample/text?account=user100
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    // http://localhost:9090/responseapiexample/json
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;
    }

    // 201 응답에 대해서 ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
