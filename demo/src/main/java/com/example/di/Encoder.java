package com.example.di;

import java.util.Base64;



public class Encoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder) {
        // this.iEncoder = new Base64Encoder();
        this.iEncoder = iEncoder;
    }
    
    public String encode(String url) {
        return iEncoder.encode(url);
    }
}