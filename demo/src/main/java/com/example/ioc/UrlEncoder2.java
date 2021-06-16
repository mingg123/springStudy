package com.example.ioc;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;


public class UrlEncoder2  implements IEncoder{
    public String encode(String message) {
       
        try {
            return URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
