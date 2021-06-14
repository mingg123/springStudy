package com.example.demo.controller;

import com.example.demo.dto.UserDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testApiController {
    

    // TEXT
    @RequestMapping("/text") 
    public String text(@RequestParam String account) {
        return account;
    }
    

    //가장 많이 사용하는
    //JSON
    // req -> object mapper -> object -> method -> object -> objectMapper -> json -> response
    @PostMapping("/json")
    public UserDto json(@RequestBody UserDto user) {
        return user;
    }


    //이걸 권장 201이나옴
    //put
    @PutMapping("/put")
    public ResponseEntity<UserDto> put(@RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
