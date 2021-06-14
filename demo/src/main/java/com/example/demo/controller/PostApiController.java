package com.example.demo.controller;

import java.util.Map;

import com.example.demo.dto.PostRequestDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {
    

    //Post같은 경우에는 RequestBody를 사용함

    
    @PostMapping("/post")
    public void post(@RequestBody PostRequestDto requestData) {

        System.out.println((requestData.toString()));
        // requestData.entrySet().forEach(stringObjectEntry-> {
        //     System.out.println("key :" + stringObjectEntry.getKey());
        //     System.out.println("value :" + stringObjectEntry.getValue());
        // });
    }
}
