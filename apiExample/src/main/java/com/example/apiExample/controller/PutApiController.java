package com.example.apiExample.controller;

import com.example.apiExample.dto.CarDto;
import com.example.apiExample.dto.PutRequestDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiexample")
public class PutApiController {
    
    @PutMapping("/put")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto) {
        System.out.println(requestDto);
        return requestDto;
    }

    @PutMapping("/put/{userId}")
    public Long put(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") Long id) {
        System.out.println(id);
        return id;
    }
}
