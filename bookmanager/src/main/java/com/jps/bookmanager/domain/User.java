package com.jps.bookmanager.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Setter
// @Getter
// @ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
// @EqualsAndHashCode
@Data
@Builder
@Entity
@Table
@EntityListeners(value = MyEntityListner.class)
public class User implements Auditable{
    @Id
    @GeneratedValue
    private Long id;
    
    @NonNull
    private String name;
    @NonNull
    private String email;

    // @Column(name="crtddt")
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Transient
    private String testData;

    @Enumerated(value= EnumType.STRING)
    private Gender gender;

    // @PrePersist
    // public void perPersist() {
    //     this.createdAt =LocalDateTime.now();
    //     this.updatedAt = LocalDateTime.now();
    //     // System.out.println(">>> prePersist");
    // }

    //  @PostPersist
    //  public void postPersist() {
    //      System.out.println(">>> postPersist");
    //  }

    // @PreUpdate
    // public void preUpdate() {
    //     this.updatedAt = LocalDateTime.now();
    //     System.out.println(">>> preUpdate");
    // }

    @PreRemove
    public void preRemove() {
        System.out.println(">>> preRemove");
    }

    @PostRemove
    public void postRemove() {
        System.out.println(">>> postRemove");
    }

    @PostLoad
    public void postLoad() {
        System.out.println(">>> postLoad");
    }



   
    
}
