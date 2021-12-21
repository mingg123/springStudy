package com.example.bookmanager.repository;

import javax.transaction.Transactional;

import com.example.bookmanager.domain.Author;
import com.example.bookmanager.domain.Book;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Transactional
    void manyToManyTest() {
        Book book1 = givenBook("책1");
        Book book2 = givenBook("책2");
        Book book3 = givenBook("책3");
        Book book4 = givenBook("책4");

        Author author1 = givenAuthor("martin");
        Author author2 = givenAuthor("steve");

        book1.addAuthor(author1);
        book2.addAuthor(author2);
        book3.addAuthor(author1, author2);
        book4.addAuthor(author1, author2);

        author1.addBook(book1, book3, book4);
        author2.addBook(book2, book3, book4);

        // book1.setAuthors(Lists.newArrayList(author1));
        // book2.setAuthors(Lists.newArrayList(author2));
        // book3.setAuthors(Lists.newArrayList(author1, author2));
        // book4.setAuthors(Lists.newArrayList(author1, author2));

        // author1.setBooks(Lists.newArrayList(book1, book3, book4));
        // author2.setBooks(Lists.newArrayList(book2, book3, book4));

        bookRepository.saveAll(Lists.newArrayList(book1, book2, book3, book4));
        authorRepository.saveAll(Lists.newArrayList(author1, author2));

        System.out.println("authors through book :" + bookRepository.findAll().get(2).getAuthorId());
        System.out.println("books through author :" + authorRepository.findAll());
    }

    private Book givenBook(String name) {
        Book book = new Book();
        book.setName(name);

        return bookRepository.save(book);
    }

    private Author givenAuthor(String name) {
        Author author = new Author();
        author.setName(name);

        return authorRepository.save(author);
    }
}
