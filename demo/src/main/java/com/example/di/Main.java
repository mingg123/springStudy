package com.example.di;

public class Main{
    public static void main(String[] args) {
        String url = "www.namer.com/books/it?page=10&size=20&name=spring-boot";


        //외부에서 주입을 받는다. 
        // IEncoder는 외부에서 주입을 받아서 Dependency Injection 임. 


        // Base 64 encoding
           Encoder encoder = new Encoder(new UrlEncoder());
        //    Encoder encoder = new Encoder(new Base64Encoder());
           String result = encoder.encode(url);
           System.out.println(result);
   


        // // Base 64 encoding
        // IEncoder encoder = new Base64Encoder();
        // String result = encoder.encode(url);
        // System.out.println(result);


        // IEncoder urlEncoder = new UrlEncoder();
        // String ulrResult = urlEncoder.encode(url);
        // System.out.println(ulrResult);
    }
}