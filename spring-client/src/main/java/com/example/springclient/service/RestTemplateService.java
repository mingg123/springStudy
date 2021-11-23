package com.example.springclient.service;

import java.net.URI;

import com.example.springclient.dto.UserResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RestTemplateService {

    // http:/localhost/springapi/server?name=mingg&age=25

    public UserResponse hello() {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090").path("/springapi/server")
                .queryParam("name", "mingg").queryParam("age", 25).encode().build().toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        // String result = restTemplate.getForObject(uri, String.class);
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
        return result.getBody();
    }
}
