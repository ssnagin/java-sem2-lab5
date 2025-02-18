/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.validation;

import com.ssnagin.lab5java.sem2.lab5.validation.errors.ValidationError;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author developer
 */
public abstract class AnnotationValidator<T> implements Validator<T> {
    
    @Override
    public List<ValidationError> validate(T object) {
        
        List<ValidationError> errors = new ArrayList<>();
                
        Field[] fields = object.getClass().getDeclaredFields();
        
        for (Field field : fields) {
//            ValidationError result = this.validateField(field, object);
//            if (result.getMessage() == "") errors.add(result);
              ValidationError result = this.validateField(field, object);
              if (result != null) errors.add(result);
        }
        System.out.println(errors.toString());
        return errors;
    }
    
    public boolean isValid(T object) {
        return validate(object).isEmpty();
    }
    
    public abstract ValidationError validateField(Field field, Object object);
}
