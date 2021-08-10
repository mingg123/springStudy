package com.jps.bookmanager.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.jps.bookmanager.domain.listener.Auditable;
import com.jps.bookmanager.domain.listener.UserEntityListener;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(value = {UserEntityListener.class})
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull
    private String name;
    @NonNull
    private String email;

    // @Column(name="crtddt")
    // @CreatedDate
    // private LocalDateTime createdAt;

    // @LastModifiedDate
    // private LocalDateTime updatedAt;

    @Transient
    private String testData;

    @Enumerated(value= EnumType.STRING)
    private Gender gender;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)  // user_id가 읽기 전용일경우 insertable, updatable을 사용한다
    private List<UserHistory> userHistoryes = new ArrayList<>();


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
