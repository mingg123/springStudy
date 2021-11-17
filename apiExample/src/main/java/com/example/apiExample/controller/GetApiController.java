package com.example.apiExample.controller;

import java.util.Map;

import com.example.apiExample.dto.UserRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiexample/get")
public class GetApiController {
    

    //아래 두 예제는 같은것 
    @GetMapping(path = "/hello")
    public String getHello() {
        return "getHello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String gethi() {
        return "getHi";
    }

    // http://localhost:9090/apiexample/api/get/path-variable/{}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable (name = "name") String pathname) {
        System.out.println("PathVariable : " + pathname);
        return pathname;
    }

    // ?key = valye & key2 = valye2 
    // http://localhost:9090/apiexample/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    //Map으로 받으려면 @RequestParam꼭 붙여주어야 한다.

    //request로 무엇이 들어올지 모를경우 Map을 사용 
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

            sb.append(entry.getKey() + "=" + entry.getValue() + "\n");
        });
        return sb.toString();
    } 


    //request로 무엇이 들어올지 알경우 
    @GetMapping(path = "query-param02")
    public String queryParam2(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
        return name + " " + email + " " + age; 
    } 

    //request로 무엇이 들어올지 알고 dto로 만들어서 (현업에서 가장많이 사용)
    @GetMapping(path="query-param03")
    public String queryParam03(UserRequest userRequest) {
        return userRequest.toString();
    }
}
