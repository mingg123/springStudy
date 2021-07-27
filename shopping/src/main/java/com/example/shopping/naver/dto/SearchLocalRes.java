package com.example.shopping.naver.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLocalRes {
    
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
   
    private List<SearchLocalItem> items;



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    //중요
    public static class SearchLocalItem {
        private String title;
        private String category;
        private String link;
        private String description;
        private String telephone;
        private String address;
        private String loadAddress;
        private int lastBuildDate;
        private int mapy;
    }
}
