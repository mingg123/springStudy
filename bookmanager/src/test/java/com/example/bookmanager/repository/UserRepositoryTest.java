package com.example.bookmanager.repository;

import com.example.bookmanager.domain.User;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Sort.Direction;

import java.util.*;

import javax.transaction.Transactional;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void crud() {
        System.out.println("crud : -----------------------------------");
        // List<User> users = userRepository.findAll();
        // List<User> users = userRepository.findAll(Sort.by(Direction.DESC, "name"));

        // List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L,
        // 5L));
        // userRepository.save(new User());
        // 실제에선 findAll은 성능 이슈때문에 잘 사용하지 않음
        // System.out.println(">>>" + userRepository.findAll());

        // userRepository.findAll().stream().forEach(System.out::println);

        // User user1 = new User("Jack", "jack@fast.com");
        // User user2 = new User("mingg", "mingg@naver.com");

        // userRepository.saveAll(Lists.newArrayList(user1, user2));
        // List<User> users = userRepository.findAll();

        // users.forEach(System.out::println);

        // User user = userRepository.getOne(1L); //getOne은 lazy 를 지원함

        // User user = userRepository.findById(1L).orElse(null); // orElse붙여주지 않으면
        // Optional로 됨
        // System.out.println(user);

        // userRepository.save(new User("new martin", "new martin@naver.com"));
        // userRepository.flush(); // 쿼리에 영향을 주는것은 아니고 DB에 반영하는 시점을 조절하는것

        // userRepository.saveAndFlush(new User("new martin", "new martin@naver.com"));
        // userRepository.findAll().forEach(System.out::println);

        // long count = userRepository.count();
        // System.out.println(count);

        // boolean exists = userRepository.existsById(1L); // count 쿼리를 사용한다.
        // System.out.println(exists);

        // userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        // userRepository.deleteById(1L);
        // userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L,
        // 3L))); //성능상의문제로 잘 사용안함
        // userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L,
        // 3L)));
        userRepository.deleteAllInBatch();
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void page() {
        Page<User> user = userRepository.findAll(PageRequest.of(1, 1));
        System.out.println("page : " + user);
        System.out.println("totalElement : " + user.getTotalElements());
        System.out.println("totalPages : " + user.getTotalPages());
        System.out.println("numberOfElements : " + user.getNumberOfElements());
        System.out.println("sort : " + user.getSort());
        System.out.println("size : " + user.getSize());
        user.getContent().forEach(System.out::println);
    }

    @Test
    void example() {
        // email이 fastcampus.com으로 끝나는 값들을 찾아라
        // ExampleMatcher matcher = ExampleMatcher.matching()
        // .withIgnorePaths("name")
        // .withMatcher("email", GenericPropertyMatchers.endsWith());

        // Example<User> example = Example.of(new User("ma", "fastcampus.com"),
        // matcher);
        // userRepository.findAll(example).forEach(System.out::println);

        // email에 slow가 포함되는 user를 찾음
        // Example이 편하긴 하지만 string에서 한정되어 있기 떄문에 생각보다 많이 안쓰이고 queryDSL이 더 많이 쓰이는 편임
        User user = new User();
        user.setEmail("slow");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", GenericPropertyMatchers.contains());
        Example<User> example = Example.of(user, matcher);

        userRepository.findAll(example).forEach(System.out::println);

    }
}
