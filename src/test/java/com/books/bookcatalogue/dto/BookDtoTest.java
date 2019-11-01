package com.books.bookcatalogue.dto;

import org.junit.Test;

import javax.validation.ConstraintViolation;

import java.io.IOException;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BookDtoTest extends DtoTestBase {


    @Test
    public void shouldSerialize() throws IOException {
        String result = objectMapper.writeValueAsString(buildBookDto());

        assertThat(result).isEqualToIgnoringWhitespace(buildBookDtoJson());
    }


    @Test
    public void shouldDeserializeFromString() throws IOException {
        BookDto result = objectMapper.readValue(buildBookDtoJson(), BookDto.class);

        assertThat(result).isEqualTo(buildBookDto());
    }

    @Test
    public void shouldThrowValidationErrorOnMissingMandatoryFields() {
        BookDto bookDto = new BookDto();
        Set<ConstraintViolation<BookDto>> violations = validator.validate(bookDto);

        assertThat(violations).hasSize(3)
                              .areExactly(1, withConstraintViolation("author", "must not be empty"))
                              .areExactly(1, withConstraintViolation("title", "must not be empty"))
                              .areExactly(1, withConstraintViolation("isbn", "must not be empty"));
    }

    private String buildBookDtoJson() {
        return "{"
               + "\"author\":\"a\", "
               + "\"title\":\"t\", "
               + "\"isbn\":\"1234\""
               + "}";
    }

    private BookDto buildBookDto() {
        return BookDto.builder()
                      .author("a")
                      .title("t")
                      .isbn("1234")
                      .build();
    }


}