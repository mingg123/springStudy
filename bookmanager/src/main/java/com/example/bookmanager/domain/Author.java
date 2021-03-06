package com.example.bookmanager.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
// @ToString(callSuper = true)
// @EqualsAndHashCode(callSuper = true)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @OneToMany
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();

    public void addBookAndAuthors(BookAndAuthor... bookandauthor) {
        Collections.addAll(this.bookAndAuthors, bookandauthor);
    }

    @ManyToMany
    // @JoinColumn(name = "author_id")
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();

    public void addBook(Book... book) {
        Collections.addAll(this.books, book);
        // if (book != null) {
        // for (Book book1 : book) {
        // this.books.add(book1);
        // }
        // }
    }
}
