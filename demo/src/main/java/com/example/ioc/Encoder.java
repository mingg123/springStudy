package com.example.ioc;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Encoder {

    private IEncoder iEncoder;

    public Encoder( IEncoder iEncoder) {
        // this.iEncoder = new Base64Encoder();
        this.iEncoder = iEncoder;
    }

    //UrlEncoder로 지정한거
    // public Encoder(@Qualifier("urlEncoder") IEncoder iEncoder) {
    //     // this.iEncoder = new Base64Encoder();
    //     this.iEncoder = iEncoder;
    // }
    
    public void setIEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String url) {
        return iEncoder.encode(url);
    }
}