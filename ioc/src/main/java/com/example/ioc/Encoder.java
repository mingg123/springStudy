package com.example.ioc;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Encoder {

    private IEncoder iEncoder;

    public Encoder(@Qualifier("urlEncoder") IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }
    // DI 주입 전
    // public Encoder() {
    // this.iEncoder = new Base64Encoder();
    // }

    public String encode(String message) {
        // return Base64.getEncoder().encodeToString(message.getBytes());
        return iEncoder.encode(message);
    }

    public void setIEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }
}
