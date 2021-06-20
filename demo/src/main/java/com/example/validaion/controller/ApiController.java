package com.example.validaion.controller;

import javax.validation.Valid;

import com.example.validaion.controller.dto.User;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/uservalidation")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {
        System.out.print(user);
        // //옛날식 코드
        // if(user.getAge() > 90 ) {
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        // }

        if(bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println(field.getField());
                System.out.println(message);

                sb.append("field : " + field.getField());
                sb.append("message : "  +message);
            });
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
       

        return ResponseEntity.ok(user);
    }
}
