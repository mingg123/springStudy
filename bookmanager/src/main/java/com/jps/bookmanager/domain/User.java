package com.jps.bookmanager.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    @NonNull
    private String name;
    @NonNull
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
