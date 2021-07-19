package com.example.client.service;

import java.net.URI;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
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

    public UserResponse post() {
        //http://localhost:9091/api/server/user/{userId}/name/{userName}
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9091").path("/api/server/user/{userId}/name/{userName}")
        .encode()
        .build()
        .expand(100, "mingg")
        .toUri();

        System.out.println(uri);

        //http body -> 
        UserRequest req = new UserRequest();
        req.setName("minji");
        req.setAge(26);

        RestTemplate restTemplate = new RestTemplate();

        //응답은 이걸로 받을거야 
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();
    }

    public UserResponse exchange() {
          //http://localhost:9091/api/server/user/{userId}/name/{userName}
          URI uri = UriComponentsBuilder.fromUriString("http://localhost:9091").path("/api/server/user/{userId}/name/{userName}")
          .encode()
          .build()
          .expand(100, "mingg")
          .toUri();
  
          System.out.println(uri);
  
          //http body -> 
          UserRequest req = new UserRequest();
          req.setName("minji");
          req.setAge(26);
  

          //헤더를 보내면서 보냄 
          RequestEntity<UserRequest> requestEntity = RequestEntity.post(uri).contentType(MediaType.APPLICATION_JSON)
          .header("x-authorization", "abcd").header("custom-header", "ffff").body(req);

          RestTemplate restTemplate = new RestTemplate();
          ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);
          return response.getBody();

    }

    public Req<UserResponse> genericExchange() {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9091").path("/api/server/user/{userId}/name/{userName}")
        .encode()
        .build()
        .expand(100, "mingg")
        .toUri();

        System.out.println(uri);

        UserRequest userRequest = new UserRequest();
        userRequest.setName("minji");
        userRequest.setAge(26);

        Req<UserRequest> req = new Req<>();
        req.setHeader(new Req.Header());
        req.setBody(userRequest);

     

        //http body -> 
     


        //헤더를 보내면서 보냄 
        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
        .post(uri)
        .contentType(MediaType.APPLICATION_JSON)
        .header("x-authorization", "abcd")
        .header("custom-header", "ffff")
        .body(req);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Req<UserResponse>> response = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<>(){});

        return response.getBody();
    }
}
