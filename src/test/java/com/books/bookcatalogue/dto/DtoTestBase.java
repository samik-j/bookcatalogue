package com.books.bookcatalogue.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Condition;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public abstract class DtoTestBase {

    protected ObjectMapper objectMapper = new ObjectMapper();

    protected Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    protected Condition<ConstraintViolation<?>> withConstraintViolation(String propertyPath, String message) {
        return new Condition<>(violation -> propertyPath.equals(violation.getPropertyPath().toString())
                                            && message.equals(violation.getMessage()), "Matching constraint violation");
    }

}
