package com.example.demo.controller;

import com.example.demo.dto.UserDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {
    
    @RequestMapping("/main")
    public String main() {
        return "<html><body><h1>Hello, ResponseBody!</h1></body></html>";
    }


    //이걸하면 age는 0, phoneNumber은 null로 온다.
    // response에 null을 포함하지 않으려면 @JsonIgnore를 사용함 
    // @JsonInclude(JsonInclude.Incluse.NON_NULL)
    @ResponseBody
    @GetMapping("/user")
    public UserDto user() {
        var user = new UserDto();
        user.setName("mingg");
        user.setAddress("패스트 캠퍼스");
        return user;
    }
}
