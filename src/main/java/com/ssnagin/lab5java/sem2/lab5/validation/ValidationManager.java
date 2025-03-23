package com.ssnagin.lab5java.sem2.lab5.validation;

import com.ssnagin.lab5java.sem2.lab5.validation.factories.ValidatorFactory;
import lombok.Singleton;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ValidationManager {
    private final Map<Annotation, ValidatorFactory> validatorFactories = new HashMap<>();
    public void validate(Object o) {
        // Посмотреть все declaredFields
        // getterAccessor
        // fieldAccessor


    }
}
