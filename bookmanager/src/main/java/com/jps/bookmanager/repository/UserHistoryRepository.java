package com.jps.bookmanager.repository;

import java.util.List;

import com.jps.bookmanager.domain.UserHistory;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
    List<UserHistory> findByUserId(Long userId);
}
