package com.ssnagin.lab5java.sem2.lab5.validation.factories;

import com.ssnagin.lab5java.sem2.lab5.validation.annotations.MinValue;
import com.ssnagin.lab5java.sem2.lab5.validation.validators.MinValueValidator;

public class MinValueValidatorFactory {
    MinValueValidator create(MinValue annotation){
        return new MinValueValidator(annotation.value());
    }
}
/// ?????