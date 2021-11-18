package com.example.ioc;

import java.util.Base64;

public class Encoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }
    // DI 주입 전
    // public Encoder() {
    // this.iEncoder = new Base64Encoder();
    // }

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
