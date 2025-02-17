/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.validation;

import java.util.List;

/**
 *
 * @author developer
 */
public abstract class AnnotationValidator<T> implements Validator<T> {
    @Override
    public abstract List<ValidationError> validate(T object);
    
    public boolean isValid(T object) {
        return validate(object).isEmpty();
    }
}
