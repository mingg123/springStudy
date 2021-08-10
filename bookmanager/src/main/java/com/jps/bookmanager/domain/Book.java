package com.jps.bookmanager.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EntityListeners(value = MyEntityListner.class)
public class Book implements Auditable{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

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
