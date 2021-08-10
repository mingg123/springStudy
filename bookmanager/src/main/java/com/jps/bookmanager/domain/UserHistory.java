package com.jps.bookmanager.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.jps.bookmanager.domain.listener.Auditable;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
//이걸 해줘야 updateAt, createAt 알 수 있음
@ToString(callSuper= true)
@EqualsAndHashCode(callSuper = true)
// @EntityListeners(value=AuditingEntityListener.class)
public class UserHistory extends BaseEntity implements Auditable{
    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String name;

    private String email;

    // @CreatedDate
    // private LocalDateTime createdAt;

    // @LastModifiedDate
    // private LocalDateTime updatedAt;
}
