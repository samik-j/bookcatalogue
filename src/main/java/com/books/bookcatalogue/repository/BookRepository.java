package com.books.bookcatalogue.repository;

import com.books.bookcatalogue.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
