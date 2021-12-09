package com.example.bookmanager.domain;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    void test() {
        User user = new User();
        user.setEmail("test@mail.com");
        user.setName("mingg");
        System.out.println(">>> " + user);

        User user1 = new User("martin", "martin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User("martin", "martin@fastcampus.com");

        // @Builder는 이런식으로 쓸 수 있음
        User.builder().name("martin").email("martin@naver.com").build();
    }
}
