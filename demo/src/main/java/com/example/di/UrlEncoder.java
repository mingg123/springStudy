package com.example.di;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncoder  implements IEncoder{
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
