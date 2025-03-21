package com.ssnagin.lab5java.sem2.lab5.validation.interfaces;

import com.ssnagin.lab5java.sem2.lab5.validation.errors.ValidationError;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Interface for classes-validators
 * @author developer
 */
public interface Validator<T> {
    public ValidationError validate(Field field, Object object);
}