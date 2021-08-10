package com.jps.bookmanager;

import com.jps.bookmanager.domain.Book;
import com.jps.bookmanager.domain.BookReviewInfo;
import com.jps.bookmanager.repository.BookRepository;
import com.jps.bookmanager.repository.BookReviewInfoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookReviewInfoRepositoryTests {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test 
    void curdTest2 () {
        giveBook();
        giveBookReviewInfo();
    
        Book result = bookReviewInfoRepository
        .findById(1L)
        .orElseThrow(RuntimeException::new)
        .getBook();

        System.out.println(">>>" + result);

        BookReviewInfo result2 = bookRepository
        .findById(1L)
        .orElseThrow(RuntimeException::new)
        .getBookReviewInfo();

        System.out.println(">>>" + result2);
    }

    @Test
    void curdTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        // bookReviewInfo.setBookId(1L); 
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);
        System.out.println(">>> " + bookReviewInfoRepository.findAll());
    }


    private Book giveBook() {
        Book book = new Book();
        book.setName("Jpa 패키지!");
        book.setAuthorId(1L);
        // book.setPublisherId(1L);

        return bookRepository.save(book);
    }


    private void giveBookReviewInfo() {
      BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(giveBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);
    }
}
