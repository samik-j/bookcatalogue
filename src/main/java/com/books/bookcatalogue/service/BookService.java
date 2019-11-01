package com.books.bookcatalogue.service;

import com.books.bookcatalogue.dto.BookDto;
import com.books.bookcatalogue.model.Book;
import com.books.bookcatalogue.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;
import java.util.stream.Collectors;

@Named
@Slf4j
public class BookService {

    private BookRepository bookRepository;

    @Inject
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(BookDto bookDto) {
        log.info("Saving book " + bookDto);
        bookRepository.save(new Book(bookDto));
    }

    public List<BookDto> getAllBooks() {
        log.info("Getting all books");
        return bookRepository.findAll().stream().map(book -> BookDto.builder()
                                                                    .author(book.getAuthor())
                                                                    .title(book.getTitle())
                                                                    .build())
                             .collect(Collectors.toList());
    }
}
