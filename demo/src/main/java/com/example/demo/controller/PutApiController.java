package com.example.demo.controller;

import com.example.demo.dto.PutRequestDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PutApiController {
    

    @PutMapping("/put/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto requestData, @PathVariable Long userId) {
        System.out.println(requestData.toString());
        return requestData;
    }
}
