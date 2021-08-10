package com.jps.bookmanager.repository;



import javax.transaction.Transactional;

import com.jps.bookmanager.domain.Author;
import com.jps.bookmanager.domain.Book;
import com.jps.bookmanager.domain.BookAndAuthor;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class AuthorRepositoryTests {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookAndAuthorRepository bookAndAuthorRepository;
   
    @Test
    @Transactional
    void manyToManyTest() {
        Book book1 = givenBook("책1");
        Book book2 = givenBook("책2");
        Book book3 = givenBook("개발책1");
        Book book4 = givenBook("개발책2");
        Book book5 = givenBook("개발책3");

        Author author1 = givenAuthor("mingg");
        Author author2 = givenAuthor("steve");
        
        // book1.addAuthor(author1);
        // book2.addAuthor(author2);
        // book3.addAuthor(author1, author2);
        // book4.addAuthor(author1, author2);

        // author1.addBook(book1, book3, book4);
        // author2.addBook(book2, book3, book4);

     

        BookAndAuthor bookAndAuthor1 = givenBookAndAuthor(book1, author1);
        BookAndAuthor bookAndAuthor2 = givenBookAndAuthor(book2, author2);
        BookAndAuthor bookAndAuthor3 = givenBookAndAuthor(book3, author1);
        BookAndAuthor bookAndAuthor4 = givenBookAndAuthor(book3, author2);
        BookAndAuthor bookAndAuthor5 = givenBookAndAuthor(book4, author1);
        BookAndAuthor bookAndAuthor6 = givenBookAndAuthor(book4, author2);


        book1.addBookAndAuthor(bookAndAuthor1);
        book2.addBookAndAuthor(bookAndAuthor2);
        book3.addBookAndAuthor(bookAndAuthor3);
        book4.addBookAndAuthor(bookAndAuthor3, bookAndAuthor4);
        book4.addBookAndAuthor(bookAndAuthor5, bookAndAuthor6);

        author1.addBookAndAuthors(bookAndAuthor1, bookAndAuthor3, bookAndAuthor5);
        author2.addBookAndAuthors(bookAndAuthor2, bookAndAuthor4, bookAndAuthor6);

        bookRepository.saveAll(Lists.newArrayList(book1, book2, book3, book4));
        authorRepository.saveAll(Lists.newArrayList(author1, author2));

        bookRepository.findAll().get(2).getBookAndAuthors().forEach(o-> System.out.println(o.getAuthor()));
        authorRepository.findAll().get(0).getBookAndAuthors().forEach(o-> System.out.println(o.getBook()));

        // System.out.println("authors through book : " + bookRepository.findAll().get(0).getAuthors());
        // System.out.println("books through author : " + authorRepository.findAll().get(0).getBooks());
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

    private BookAndAuthor givenBookAndAuthor(Book book, Author author) {
        BookAndAuthor bookAndAuthor = new BookAndAuthor();
        bookAndAuthor.setAuthor(author);
        bookAndAuthor.setBook(book);

        return bookAndAuthorRepository.save(bookAndAuthor);
    }
}
