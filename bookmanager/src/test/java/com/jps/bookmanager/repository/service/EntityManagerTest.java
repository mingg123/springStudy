package com.jps.bookmanager.repository.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.jps.bookmanager.domain.User;
import com.jps.bookmanager.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class EntityManagerTest {
    
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void entityManagerTest() {
        System.out.println(entityManager.createQuery("Select u from User u").getResultList());
    }

    @Test
    void cacheFindTest(){
        // System.out.println(userRepository.findById(1L).get());
        //      System.out.println(userRepository.findById(1L).get());
        //           System.out.println(userRepository.findById(1L).get());
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
    }

      @Test
    void cacheFindTest2(){
        User user = userRepository.findById(1L).get();
        user.setName("marrrrrrr");
        userRepository.save(user);
        System.out.println("-------------");
        user.setEmail("marggggggg@fastcampous.com");
        userRepository.save(user);
        userRepository.flush();
        // System.out.println(userRepository.findById(1L).get());
        //      System.out.println(userRepository.findById(1L).get());
        //           System.out.println(userRepository.findById(1L).get());
        // System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        // System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
    }
}
