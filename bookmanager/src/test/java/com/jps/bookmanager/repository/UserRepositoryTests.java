package com.jps.bookmanager.repository;



import static org.mockito.ArgumentMatchers.contains;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.jps.bookmanager.domain.Gender;
import com.jps.bookmanager.domain.User;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void curd() {

        User user1 = new User("ming", "jack@naver.com");
        // User user2 = new User("steave", "jack@naver.com");
        // User user3 = new User("steave2", "jack2@naver.com");

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        // user.setEmail("martin-update@fastcampus.com");
        userRepository.save(user);

        // ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email" , contains().ignoreCase());



        // Example<User> example = Example.of(new User("ma", "fastcampos.com"), matcher);
        // userRepository.findAll(example).forEach(System.out::println);

        // userRepository.findAll().forEach(System.out::println);

        // userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
        //  userRepository.findAll().forEach(System.out::println);

        //Page 예제 
        //  Page<User> users = userRepository.findAll(PageRequest.of(1,3));
        //  System.out.println("page : " + users);
        //  System.out.println("totalElements :" + users.getTotalElements());
        //  System.out.println("totalages:" + users.getTotalPages());
        //  System.out.println("numberOfElements:" + users.getNumberOfElements());
        //  System.out.println("sort:" + users.getSort());
        //  System.out.println("size:" + users.getSize());
        //  users.getContent().forEach(System.out::println);



        // User user3 = new User("hello", "jack@naver.com");
        // userRepository.saveAll(Lists.newArrayList(user1, user2, user3));

        // List<User> users = userRepository.findAll();

        // users.forEach(System.out::println);


        // userRepository.saveAndFlush(new User("new jack", "new email.com"));
        // userRepository.findAll().forEach(System.out::println);

        // long count = userRepository.count();
        // System.out.println(count);

        // boolean exists = userRepository.existsById(1L);
        // System.out.println(exists);

        // userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        // userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L)));
        // users.forEach(System.out::println);
        // List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
        // List<User> users = userRepository.findAll(Sort.by(Direction.DESC, "name"));
        // users.forEach(System.out::println);

        // //User Table에 저장한다. 
        // userRepository.save(new User());

        // // user Table에 있는 모든 데이터를 리스트로 가져오겟다
        // // System.out.println(">>>" + userRepository.findAll());
        // userRepository.findAll().forEach(System.out::println);
    }
    @Test
    void select() {
        User user = new User("ming", "jack@naver.com");
        userRepository.save(user);
        System.out.println(userRepository.findByName("ming"));
        System.out.println("findByEmail " + userRepository.findByEmail("jack@naver.com"));
        System.out.println("findByEmail " + userRepository.getByEmail("jack@naver.com"));
        System.out.println("findByEmail " + userRepository.readByEmail("jack@naver.com"));
        System.out.println("findByEmail " + userRepository.queryByEmail("jack@naver.com"));
        System.out.println("findByEmail " + userRepository.searchByEmail("jack@naver.com"));
        System.out.println("findByEmail " + userRepository.streamByEmail("jack@naver.com"));
        System.out.println("findByEmail " + userRepository.findUserByEmail("jack@naver.com"));
        System.out.println("findFirst1ByName" + userRepository.findFirst1ByName("jack@naver.com"));
        System.out.println("findLast1ByName" + userRepository.findLast1ByName("ming"));
    }

    @Test
    void insertAndUpdateTest() {
        User user = new User();
        user.setId(1L);
        user.setName("mingggg");
        user.setEmail("mingg@naver.com");
        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setId(2L);
        user2.setName("mingggggg2");
        user2.setEmail("mingggg2@naver.com");

        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRowRecord().get("gender"));
    }

    @Test
    void listenerTest() {
        User user = new User();
        user.setEmail("mingg@naver.com");
        user.setName("mingg");

        userRepository.save(user);

        User user2= userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("mingggg2");
        user2.setEmail("mingggg2@naver.com");

        userRepository.deleteById(2L);
    }

    @Test
    void prePersistestTest() {
        User user = new User();
        user.setEmail("minggg@naver.com");
        user.setName("minggg");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);

        System.out.println(userRepository.findByEmail("minggg@naver.com"));
    }

    @Test
    void preUpdateTest() {
        User user = new User();
        user.setEmail("minggg@naver.com");
        user.setName("minggg");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        System.out.println("as-is :" + user2);
        user.setName("mingggg");
        userRepository.save(user2);

        System.out.println("to-be: " + userRepository.findAll().get(0));
    }
}
