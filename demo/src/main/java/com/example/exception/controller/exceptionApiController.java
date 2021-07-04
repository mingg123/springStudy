package com.example.exception.controller;

import javax.validation.Valid;

import com.example.exception.dto.User2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user3")
public class exceptionApiController {
    
    @RequestMapping("/get")
    public User2 get(@RequestParam(required = false) String name, @RequestParam(required =  false) int age) {
    User2 user = new User2();
    user.setName(name);
    user.setAge(age);

    int a = 10+age;

    return user;
    }

    @RequestMapping("/post")
    public User2 post(@Valid @RequestBody User2 user) {
        System.out.println(user);
        return user;
    }

    //특정한 controller에 exception 주고싶을 경우
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println("api controller");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }
}
