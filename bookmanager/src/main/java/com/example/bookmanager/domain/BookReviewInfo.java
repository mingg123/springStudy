package com.example.bookmanager.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class BookReviewInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;
    // Float나 Integer type을 사용할 경우 null을 체크하지않으면 nullpointException 발생함
    private float averageReviewScore;

    private int reviewCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
