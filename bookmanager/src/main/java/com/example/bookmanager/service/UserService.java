package com.example.bookmanager.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.bookmanager.domain.User;
import com.example.bookmanager.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void put() {
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@fastcampus.com");

        // 이걸 사용해주지 않으면 비영속상태임.
        // userRepository.save(user);

        entityManager.persist(user);
        // entityManager.detach(user);

        user.setName("newUserAfterPersist");
        entityManager.merge(user);
        // userRepository.save(user);
        // entityManager.flush();
        // entityManager.clear();

        entityManager.remove(user);

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);
    }

}
