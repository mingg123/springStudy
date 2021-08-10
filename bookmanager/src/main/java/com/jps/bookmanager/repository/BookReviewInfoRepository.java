package com.jps.bookmanager.repository;

import com.jps.bookmanager.domain.BookReviewInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewInfoRepository  extends JpaRepository<BookReviewInfo, Long> {
    
}
