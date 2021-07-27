package com.example.shopping.wishlist.repository;

import org.springframework.stereotype.Repository;
import com.example.shopping.db.MemoryDbRepositoryAbstract;
import com.example.shopping.wishlist.entity.WishListEntity;

@Repository
public class WishListRepository  extends MemoryDbRepositoryAbstract<WishListEntity>{
    
}
