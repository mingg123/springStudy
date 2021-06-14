package com.example.demo.controller;


import java.util.Map;

import com.example.demo.dto.UserRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get")

public class GetApiController {

    //Get Method를 설정해주지 않아도 됨
    @GetMapping(path = "/hello2")  //http://localhost:9090/api/get/hello2
    public String hello2() {
        return "get Hello2";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)  //http://localhost:9090/api/get/hi
    public String hi() {
        return "hi";
    }
    
    // //내가 입력받는 값에 따라 결과가 나오도록 Path Variable

    // @GetMapping(path = "/path-variable/{name}")  //http://localhost:9090/api/get/path-variable/{name}
    // public String pathVariable(@PathVariable String name) {
    //     System.out.println("PathVariable :" + name);
        
    //     return name;
    // }

    @GetMapping(path = "/path-variable/{name}")  //http://localhost:9090/api/get/path-variable/{name}
    public String pathVariable(@PathVariable(name = "name") String PathName) {
        System.out.println("PathVariable :" + PathName);
        
        return PathName;
    }


    //query Parameter 처음 시작은 ? 그 이후에는 & 를 사용함
    // ?key=value & key2=value2 
    
    //http://localhost:9090/api/get/query-param?name=stev&email=steve@gmail.com&age=30
    //@RequestParam을 사용해서 queryParam을 받아올수 있음

    @GetMapping(path="query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = "+(entry.getValue())+ "\n");
        });
        return sb.toString();
    }

    //명시적으로 변수를 받아서 name, email, age가 들어옴 
    @GetMapping(path="query-param02")  //http://localhost:9090/api/get/query-param02?name=김민지&email=minji@gmail.com&age=50
    public String queryParam02(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " " + email + " " + age;
    }

    //현업에서 제일많이쓰고 추천 
    //UserRequest.java DTO를 만듬
    @GetMapping(path="query-param03")  //http://localhost:9090/api/get/query-param03?name=김민지&email=minji@gmail.com&age=50
    public String queryParam03(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.getName().toString();
    }




}