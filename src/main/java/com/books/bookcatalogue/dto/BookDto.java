package com.books.bookcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    @NotEmpty
    private String author;

    @NotEmpty
    private String title;

    @NotEmpty
    private String isbn;

}
