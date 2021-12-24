package com.example.bookmanager.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.bookmanager.domain.User;
import com.example.bookmanager.repository.UserRepository;

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

    // userRepository에 findAll() 메소드와 같음
    @Test
    void entityManagerTest() {
        System.out.println(entityManager.createQuery("select u from User u").getResultList());
    }

    @Test
    void cacheFindTest() {
        // System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        // System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        // System.out.println(userRepository.findById(1L).get());
        // System.out.println(userRepository.findById(1L).get());
        // System.out.println(userRepository.findById(1L).get());
        userRepository.deleteById(1L);
    }

    @Test
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();
        user.setName("marrrrrrrtin");
        userRepository.save(user);
        // userRepository.flush();
        user.setEmail("martttttttin@fastcampus.com");
        userRepository.save(user);
        // userRepository.flush();
        System.out.println(">>> 1 : " + userRepository.findById(1L).get());

        // userRepository.flush();

        System.out.println(">>> 2 : " + userRepository.findById(1L).get());
    }

    @Test
    void cacheFindTest3() {
        User user = userRepository.findById(1L).get();
        user.setName("marrrrrrrtin");
        userRepository.save(user);
        // userRepository.flush();
        user.setEmail("martttttttin@fastcampus.com");
        userRepository.save(user);
        // userRepository.flush();
        System.out.println(userRepository.findAll());
        // System.out.println(">>> 1 : " + userRepository.findById(1L).get());

        // userRepository.flush();

        // System.out.println(">>> 2 : " + userRepository.findById(1L).get());
    }

}
