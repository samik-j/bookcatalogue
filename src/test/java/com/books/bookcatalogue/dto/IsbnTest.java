package com.books.bookcatalogue.dto;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class IsbnTest {

    @Test
    public void shouldBeValid() {
        String isbn = "1234567890123";

        Isbn isbn1 = new Isbn(isbn);
    }

    @Test
    public void shouldNotBeValid() {
        String isbn = "11234567890123";

        assertThrows(IllegalArgumentException.class, () -> new Isbn(isbn));
    }
}