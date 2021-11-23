package com.example.naverapi.naver;

import com.example.naverapi.naver.dto.SearchLocalReq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClient {

    @Value("${naver_id}")
    private static String naverClientId;

    @Value("${naver_secret}")
    private String naverSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;

    // https:// openapi.naver.com/v1/search/local.json
    public SearchLocalReq localSearch(SearchLocalReq SearchLocalReq) {
        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl).queryParams(SearchLocalReq.toMultiValueMap())
                .build().encode().toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", "2lWzsgurEbA9GM8DhY7s");
        headers.set("X-Naver-Client-Secret", "nGRNN_CStH");
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchLocalReq>() {
        };

        var responseEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, responseType);
        return responseEntity.getBody();
    }

    public void ImageSearch() {

    }
}
