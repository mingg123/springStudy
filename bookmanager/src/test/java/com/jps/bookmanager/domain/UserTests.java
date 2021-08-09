package com.jps.bookmanager.domain;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class UserTests {
    @Test
    void test() {
        User user = new User();
        user.setEmail("miwook3025");
        user.setName("mingg");
        
        // User user1 = new User("name", "email", LocalDateTime.now(), LocalDateTime.now());
        User user3 = User.builder().name("name").email("email").build();

        System.out.println(">>>" + user.toString());
    }    
}
