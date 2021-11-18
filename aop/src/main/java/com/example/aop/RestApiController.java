package com.example.aop;

import com.example.aop.dto.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/aopexample")
@RestController
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        System.out.println("get method");
        System.out.println(id);
        System.out.println(name);
        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        System.out.println("post method");
        System.out.println(user);
        return user;
    }
}
