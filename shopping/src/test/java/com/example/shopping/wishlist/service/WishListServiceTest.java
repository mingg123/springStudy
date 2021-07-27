package com.example.shopping.wishlist.service;

import com.example.shopping.service.WishListService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.var;

@SpringBootTest
public class WishListServiceTest {
    

    @Autowired
    private WishListService wishListService;

    @Test
    public void searchTest() {
        var result = wishListService.search("옷집");
        System.out.println(result);
        Assertions.assertNotNull(result);
    }

}
