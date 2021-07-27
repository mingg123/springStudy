package com.example.shopping.controller;

import java.util.List;

import com.example.shopping.service.WishListService;
import com.example.shopping.wishlist.dto.WishListDO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/shopping")
@RequiredArgsConstructor
public class ApiController {
    
    private final WishListService wishListService;

    @GetMapping("/search")
    public WishListDO search(@RequestParam String query) {
        return wishListService.search(query);
    }

    @PostMapping()
    public WishListDO add(@RequestBody WishListDO wishListDO) {
        log.info("{}}", wishListDO);

        return wishListService.add(wishListDO);
    }

    @GetMapping("/all")
    public List<WishListDO> findAll() {
        return wishListService.findAll();
    }


    @DeleteMapping("/{index}") 
    public void delete(@PathVariable int index) {
        wishListService.delete(index);
    }

     @PostMapping("/{index}")
    public void addVisit(@PathVariable  int index) {
        wishListService.addVisit(index);
    }
}
