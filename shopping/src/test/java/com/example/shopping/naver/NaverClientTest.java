package com.example.shopping.naver;

import com.example.shopping.naver.NaverClient;
import com.example.shopping.naver.dto.SearchImageReq;
import com.example.shopping.naver.dto.SearchLocalReq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.var;


@SpringBootTest
public class NaverClientTest {
    
    @Autowired
    private NaverClient naverClient;


    @Test
    public void localSearchTest() {
        var search = new SearchLocalReq();
        search.setQuery("옷집");

        var result = naverClient.localSearch(search);
        System.out.println(result);

    }

    @Test
    public void ImageSearchTest() {
        var search = new SearchImageReq();
        search.setQuery("옷집");

        var result = naverClient.imageSearch(search);
      
        System.out.println(result);

    }

}
