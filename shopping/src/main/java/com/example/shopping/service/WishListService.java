package com.example.shopping.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.shopping.naver.NaverClient;
import com.example.shopping.naver.dto.SearchImageReq;
import com.example.shopping.naver.dto.SearchImageRes;
import com.example.shopping.naver.dto.SearchLocalReq;
import com.example.shopping.naver.dto.SearchLocalRes;
import com.example.shopping.wishlist.dto.WishListDO;
import com.example.shopping.wishlist.entity.WishListEntity;
import com.example.shopping.wishlist.repository.WishListRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final NaverClient naverClient;

    private final WishListRepository wishListRepository;

    public WishListDO search(String query) {
        //지역검색
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.localSearch(searchLocalReq);

        if (searchLocalRes.getTotal() > 0) {
            var localItem = searchLocalRes
                .getItems()
                .stream()
                .findFirst()
                .get();

            //검색에 용이하도록
            var imageQuery = localItem
                .getTitle()
                .replaceAll("<[^>]*", "");
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            var searchImageRes = naverClient.imageSearch(searchImageReq);
            if (searchImageRes.getTotal() > 0) {
                var imageItem = searchImageRes
                    .getItems()
                    .stream()
                    .findFirst()
                    .get();

                //결과를 리턴
                var result = new WishListDO();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setLoadAddress(localItem.getLoadAddress());
                result.setHomePageLink(localItem.getLink());
                result.setImageLink(imageItem.getLink());
                return result;
            }
        }

        // 이미지 검색

        return new WishListDO();

    }

    public WishListDO add(WishListDO wishListDO) {
        var entity = dtoToEntity(wishListDO);
        var saveEntity = wishListRepository.save(entity);
        return entityToDto(saveEntity);
    }

    private WishListEntity dtoToEntity(WishListDO wishListDO) {
        var entity = new WishListEntity();
        entity.setIndex(wishListDO.getIndex());
        entity.setTitle(wishListDO.getTitle());
        entity.setCategory(wishListDO.getCategory());
        entity.setAddress(wishListDO.getAddress());
        entity.setLoadAddress(wishListDO.getLoadAddress());
        entity.setHomePageLink(wishListDO.getHomePageLink());
        entity.setImageLink(wishListDO.getImageLink());
        entity.setVisit(wishListDO.isVisit());
        entity.setVisitCount(wishListDO.getVisitCount());
        entity.setLastVisitData(wishListDO.getLastVisitData());
        return entity;
    }

    private WishListDO entityToDto(WishListEntity wishListEntity) {

        var dto = new WishListDO();
        dto.setIndex(wishListEntity.getIndex());
        dto.setTitle(wishListEntity.getTitle());
        dto.setCategory(wishListEntity.getCategory());
        dto.setAddress(wishListEntity.getAddress());
        dto.setLoadAddress(wishListEntity.getLoadAddress());
        dto.setHomePageLink(wishListEntity.getHomePageLink());
        dto.setImageLink(wishListEntity.getImageLink());
        dto.setVisit(wishListEntity.isVisit());
        dto.setVisitCount(wishListEntity.getVisitCount());
        dto.setLastVisitData(wishListEntity.getLastVisitData());
        return dto;

    }

    public List<WishListDO> findAll() {
        return wishListRepository.findAll()
        .stream().map(it-> entityToDto(it)).collect(Collectors.toList());
    }

    public void delete(int index) {
        wishListRepository.deleteById(index);
    }

    public void addVisit(int index) {
        var wishItem = wishListRepository.findById(index);
        if(wishItem.isPresent()) {
            var item = wishItem.get();

            item.setVisit(true);
            item.setVisitCount(item.getVisitCount()+1);
        }
    }

   
}
