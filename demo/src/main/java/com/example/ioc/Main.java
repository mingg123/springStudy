package com.example.ioc;




import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Main {
    
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();

        // Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        // UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
        // Encoder encoder = new Encoder(base64Encoder);
        Encoder encoder = context.getBean(Encoder.class);
        String url = "www.namer.com/books/it?page=10&size=20&name=spring-boot";

        String result = encoder.encode(url);
        System.out.println(result);

        // encoder.setIEncoder(urlEncoder);
        // result = encoder.encode(url);
        // System.out.println(result);

    }
}


// @Configuration 
// class AppConfig{

//     @Bean("base64Encod")
//     public Encoder encoder(Base64Encoder base64Encoder) {
//         return new Encoder(base64Encoder);
//     }

//     @Bean("urlEncod")
//     public Encoder encoder(UrlEncoder urlEncoder) {
//         return new Encoder(urlEncoder);
//     }
// }