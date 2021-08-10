package com.jps.bookmanager.repository;

import com.jps.bookmanager.domain.UserHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
    
}
