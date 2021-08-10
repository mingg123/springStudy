package com.jps.bookmanager.repository;

import javax.transaction.Transactional;

import com.jps.bookmanager.domain.Book;
import com.jps.bookmanager.domain.Publisher;
import com.jps.bookmanager.domain.Review;
import com.jps.bookmanager.domain.User;
import com.jps.bookmanager.domain.listener.UserEntityListener;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTests {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;



    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("jpa 패키지");
        book.setAuthorId(1L);
        // book.setPublisherId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest() {
        giveBookAndReview();
        User newuser = new User();
        newuser.setEmail("mingg@naver.com");
        newuser.setName("minji");
        userRepository.save(newuser);
        User user = userRepository.findByEmail("mingg@naver.com");
        System.out.println("Review : " + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher :" + user.getReviews().get(0).getBook().getPublisher());
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("캠퍼스");
        return publisherRepository.save(publisher);
    }

    private void giveBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("책책!");
        book.setPublisher(publisher);
        return bookRepository.save(book);
    }

    private User givenUser() {
        return userRepository.findByEmail("mingg@naver.com");
    }

    private void givenReview(User user, Book book) {
        Review review = new Review();
        review.setTitle("하이");
        review.setContent("책내용");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);
        reviewRepository.save(review);
    }
}
