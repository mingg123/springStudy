package com.example.client.service;

import java.net.URI;

import com.example.client.dto.UserResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RestTemplateService {
    
    //http: //locallhost/api/server/hello
    //response
    public UserResponse hello() {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9091").path("/api/server/hello").queryParam("name", "ming").queryParam("age", 25).encode().build().toUri();
        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        // String result = restTemplate.getForObject(uri, String.class);
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
        return result.getBody();
    }
}
