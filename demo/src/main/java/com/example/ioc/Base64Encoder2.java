package com.example.ioc;

import java.util.Base64;

import org.springframework.stereotype.Component;


//컴포넌트 붙이면 스프링에서 관리를 해줘 라는 뜻임. base64가 bean으로 등록된다.

@Component("base64Encoder3")
public class Base64Encoder2 implements IEncoder{

    @Override
    public String encode(String message) {

        return Base64.getEncoder().encodeToString(message.getBytes());
         
    }
    
}
