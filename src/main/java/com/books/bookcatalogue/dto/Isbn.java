package com.books.bookcatalogue.dto;

import lombok.Data;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Isbn {

    private static final String REGEX = "^[0-9]{13}";

    private final String value;

    public Isbn(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        Matcher m = Optional.of(Pattern.compile(REGEX)).get().matcher(value);
        if(!m.matches()) {
            throw new IllegalArgumentException("Isbn does not match regex");
        }
    }
}
