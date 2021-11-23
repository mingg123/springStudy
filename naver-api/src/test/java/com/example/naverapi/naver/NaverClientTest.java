package com.example.naverapi.naver;

import com.example.naverapi.naver.dto.SearchLocRes;
import com.example.naverapi.naver.dto.SearchLocalReq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {

    @Autowired
    private NaverClient naverClient;

    @Test
    public void localSearchTest() {
        var search = new SearchLocalReq();
        search.setQuery("갈비집");

        var result = naverClient.localSearch(search);
        System.out.println(result);
    }
}
