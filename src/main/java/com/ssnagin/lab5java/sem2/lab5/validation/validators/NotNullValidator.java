package com.ssnagin.lab5java.sem2.lab5.validation.validators;

import java.util.Objects;

public class NotNullValidator implements Validator<Object> {
    public static final String NULL_VALUE_ERROR = "Expected value but null is given";

    @Override
    public void validate(Object value) {
        if(Objects.isNull(value))
            throw new IllegalArgumentException(String.format(NULL_VALUE_ERROR));
    }
}
