package com.jps.bookmanager.repository;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.jps.bookmanager.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// 자바 인터페이스를 선언해주고 jpa를 상속받으면서 기능을 사용하게 해줌 처음은 엔티티 타입, User의 PK를 가짐 JPA관련된 많은
// 매서드를 사용가능
public interface UserRepository extends JpaRepository<User, Long> {
    // Optional<User> findByName(String name); User findByName(String name);

    Set<User> findByName(String name);
    User findByEmail(String email);
    User getByEmail(String email);
    User readByEmail(String email);
    User queryByEmail(String email);
    User searchByEmail(String email);
    User streamByEmail(String email);
    User findUserByEmail(String email);
    User findFirst1ByName(String name);
    User findTop2ByName(String name);
    User findLast1ByName(String name);

    @Query(value="select * from user limit 1;", nativeQuery = true)
    Map<String, Object> findRowRecord();
}
