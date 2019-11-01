package com.books.bookcatalogue.service;

import com.books.bookcatalogue.dto.BookDto;
import com.books.bookcatalogue.model.Book;
import com.books.bookcatalogue.repository.BookRepository;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;
import java.util.stream.Collectors;

@Named
public class BookService {

    private BookRepository bookRepository;

    @Inject
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(BookDto bookDto) {
        bookRepository.save(new Book(bookDto));
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> BookDto.builder()
                                                                    .author(book.getAuthor())
                                                                    .title(book.getTitle())
                                                                    .build())
                             .collect(Collectors.toList());
    }
}
