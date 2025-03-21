/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.validation.classes;

import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.validation.errors.ValidationError;
import com.ssnagin.lab5java.sem2.lab5.validation.annotations.MaxValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.MessageFormat;

/**
 *
 * @author developer
 */
public class MaxValueValidator extends AnnotationValidator<MaxValue> {
    
    @Override
    public Class<MaxValue> getAnnotationClass() {
        return MaxValue.class;
    }
    
    @Override
    public ValidationError validateField(MaxValue annotation, Field field, Object object) {
                
        Long maxValue = annotation.maxValue();
        String showMessage = annotation.showMessage();
          
        field.setAccessible(true);

        try {
            Object value = field.get(object); // ЗДЕСЬ
            if (!(value instanceof Number)) return new ValidationError("","Object is not an instance of Number");
            
            long fieldValue = ((Number) value).longValue();
              
            if (fieldValue > maxValue) return new ValidationError(value, MessageFormat.format(showMessage, maxValue));
              
            return null;
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Console.error(ex);
        }
        return null;
    }
}
