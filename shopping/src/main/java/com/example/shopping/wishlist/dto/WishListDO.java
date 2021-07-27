package com.example.shopping.wishlist.dto;

import java.time.LocalDateTime;

import com.example.shopping.db.MemoryDbEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListDO  extends MemoryDbEntity{

    private String title;
    private String category;
    private String address;
    private String loadAddress;
    private String homePageLink;
    private String imageLink;
    private boolean isVisit;
    private int visitCount;
    private LocalDateTime lastVisitData;
}
