package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

//처음은 entityType 두번째 인자는 PK의 Type
public interface UserRepository extends JpaRepository<User, Long> {

    // List<User> findByIdIsNotEmpty();

    List<User> findByAddressIsNotEmpty();

    List<User> findByNameIn(List<String> name);

    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndingWith(String name);

    List<User> findByNameContains(String name);

    List<User> findByNameLike(String name);

    List<User> findByName(String name);

    Set<User> findUserByName(String name);

    Set<User> findUserByNameEquals(String name);

    List<User> findTop1ByName(String name);

    List<User> findLast1ByName(String name);

    List<User> findByEmail(String name);

    List<User> findTop1ByNameOrderByIdDesc(String name);

    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<User> findFirstByName(String name, Sort sort);

    @Query(value = "select * from user limit 1;", nativeQuery = true)
    Map<String, Object> findRawRecord();

}
