package com.ssnagin.lab5java.sem2.lab5.validation;

import com.ssnagin.lab5java.sem2.lab5.validation.errors.ValidationError;
import java.util.List;

/**
 * Interface for validating objects
 * @author developer
 */
public interface Validator<T> {
    public List<ValidationError> validate(T object);
}