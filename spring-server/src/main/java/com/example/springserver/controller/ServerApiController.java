package com.example.springserver.controller;

import com.example.springserver.dto.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springapi/server")
public class ServerApiController {

    @GetMapping("")
    public User hello(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        // user.setName("minji");
        // user.setAge(10);
        user.setName(name);
        user.setAge(age);
        return user;
    }
}
