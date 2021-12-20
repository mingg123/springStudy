package com.example.bookmanager.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

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

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@Entity
@Table(name = "user", indexes = { @Index(columnList = "name") }, uniqueConstraints = {
        @UniqueConstraint(columnNames = { "email" }) })
public class User {
    @Id // pk임
    @GeneratedValue // 1씩 증가
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;

    // update 문에서 사용하지 않겠다는 의미
    @Column(updatable = false)
    private LocalDateTime createdAt;

    // insert 문에서 사용하지 않겠다.
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    // 영속성에 반영되지 않고 DB에 반영하는게 아니라 그냥 사용하고 싶을 경우에 쓴다.
    @Transient
    private String test_data;

    // 이걸 붙여주지 않으면 male 은 0, female는 1로 저장이 되어 있음. 굉장히 많은 실수를 발생하는 부분임. enum을 사용할경우엔
    // enumerated를 꼭 사용해주어야함
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Addres> address;

}
