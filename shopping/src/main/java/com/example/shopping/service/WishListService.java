package com.example.shopping.service;

import com.example.shopping.naver.NaverClient;
import com.example.shopping.naver.dto.SearchImageReq;
import com.example.shopping.naver.dto.SearchImageRes;
import com.example.shopping.naver.dto.SearchLocalReq;
import com.example.shopping.naver.dto.SearchLocalRes;
import com.example.shopping.wishlist.dto.WishListDO;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final NaverClient naverClient;

    public WishListDO search(String query) {
        //지역검색
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.localSearch(searchLocalReq);

        if(searchLocalRes.getTotal() > 0) {
            var localItem = searchLocalRes.getItems().stream().findFirst().get();

            //검색에 용이하도록 
            var imageQuery = localItem.getTitle().replaceAll("<[^>]*", "");
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            var searchImageRes = naverClient.imageSearch(searchImageReq);
            if(searchImageRes.getTotal() > 0) {
                var imageItem = searchImageRes.getItems().stream().findFirst().get();

                //결과를 리턴
                var result = new WishListDO();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setReadAddress(localItem.getRoadAddress());
                result.setHomePageLink(imageItem.getLink());
                result.setImageLink(localItem.getLink());
                return result;
            }
        } 

        // 이미지 검색

        return new WishListDO();
   
    }
    
}
