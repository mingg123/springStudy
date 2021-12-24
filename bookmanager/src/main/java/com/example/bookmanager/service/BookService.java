package com.example.bookmanager.service;

import javax.management.RuntimeErrorException;

import com.example.bookmanager.domain.Author;
import com.example.bookmanager.domain.Book;
import com.example.bookmanager.repository.AuthorRepository;
import com.example.bookmanager.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public void put() {
        this.putBookAndAuthor();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void putBookAndAuthor() {
        Book book = new Book();
        book.setName("JPA");

        bookRepository.save(book);

        // authorservice.putAuthor();
        Author author = new Author();
        author.setName("martin");

        authorRepository.save(author);

        throw new RuntimeException("오류가 나서 DB commit이 발생하지 않습니다");
        // throw new RuntimeErrorException(null, "오류가 나서 DB commit이 발생하지 않습니다");
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void get(Long id) {
        System.out.println(">>>" + bookRepository.findById(id));
        System.out.println(">>>" + bookRepository.findAll());

        System.out.println(">>>" + bookRepository.findById(id));
        System.out.println(">>>" + bookRepository.findAll());

        // Book book = bookRepository.findById(id).get();
        // book.setName("바껴라");
        // bookRepository.save(book);
    }
}
