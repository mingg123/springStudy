package com.jps.bookmanager.repository;

import com.jps.bookmanager.domain.Book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTests {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("jpa 패키지");
        book.setAuthor("저자");

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }
}
