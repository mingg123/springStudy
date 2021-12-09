package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

//처음은 entityType 두번째 인자는 PK의 Type
public interface UserRepository extends JpaRepository<User, Long> {

}
