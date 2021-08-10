package com.jps.bookmanager.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.jps.bookmanager.domain.listener.Auditable;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
// @EntityListeners(value = AuditingEntityListener.class)
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // private String author;

    private String category;

    private Long authorId;

    private Long publisherId;

    @OneToOne(mappedBy = "book")
    @ToString.Exclude
    private BookReviewInfo bookReviewInfo;
    // private LocalDateTime createdAt;

    // private LocalDateTime updatedAt;

    // @PrePersist
    // public void perPersist(){
    //     this.createdAt = LocalDateTime.now();
    //     this.updatedAt = LocalDateTime.now();
    // }

    // @PreUpdate
    // public void preUpdate() {
    //     this.updatedAt = LocalDateTime.now();
    // }
}
