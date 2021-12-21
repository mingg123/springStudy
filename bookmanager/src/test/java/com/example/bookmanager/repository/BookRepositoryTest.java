package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.BookReviewInfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("Jpa");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        bookRepository.save(book);
        System.out.println(bookRepository.findAll());
    }
}