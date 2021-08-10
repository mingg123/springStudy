package com.jps.bookmanager.repository;

import com.jps.bookmanager.domain.Author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
