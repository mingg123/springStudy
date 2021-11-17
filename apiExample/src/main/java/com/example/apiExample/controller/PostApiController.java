package com.example.apiExample.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/apiexample")
@RestController
public class PostApiController {

    //getMapping에서는 ReqeustParam을 붙여줬듯이 post에넌 RequestBody를 붙여줘야함
    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData){
        // requestData.entrySet().forEach(stringObjectEntry -> {
        //     System.out.println("key: " + stringObjectEntry.getKey());
        //     System.out.println("value: " + stringObjectEntry.getValue());
        // });
            System.out.println(requestData);
    }
    
}
