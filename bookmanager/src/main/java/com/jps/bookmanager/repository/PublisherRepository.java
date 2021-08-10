package com.jps.bookmanager.repository;

import com.jps.bookmanager.domain.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository  extends JpaRepository<Publisher, Long>{
    
}
