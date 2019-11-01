package com.books.bookcatalogue.model;

import com.books.bookcatalogue.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String title;

    public Book (BookDto bookDto) {
        this.isbn = bookDto.getIsbn();
        this.author = bookDto.getAuthor();
        this.title = bookDto.getTitle();
    }
}

