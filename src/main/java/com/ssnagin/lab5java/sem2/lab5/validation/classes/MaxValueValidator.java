/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.validation.classes;

import com.ssnagin.lab5java.sem2.lab5.validation.AnnotationValidator;
import com.ssnagin.lab5java.sem2.lab5.validation.errors.ValidationError;
import com.ssnagin.lab5java.sem2.lab5.validation.annotations.MaxValue;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author developer
 */
public class MaxValueValidator<T> extends AnnotationValidator<T> {
    
      @Override
      public ValidationError validateField(Field field, Object object) {
          
          if (!field.isAnnotationPresent(MaxValue.class)) return null;
          
          MaxValue maxValueAnnotation = field.getAnnotation(MaxValue.class);
          
          Long maxValue = maxValueAnnotation.maxValue();
          String showMessage = maxValueAnnotation.showMessage();
          
          field.setAccessible(true);

          try {
              Object value = field.get(object);
              if (!(value instanceof Number)) return null;
              
              long fieldValue = ((Number) value).longValue();
              
              if (fieldValue > maxValue) return new ValidationError(value, MessageFormat.format(showMessage, maxValue));
              
              return null;
          } catch (IllegalArgumentException ex) {
              Logger.getLogger(MaxValueValidator.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
              Logger.getLogger(MaxValueValidator.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
          
          
      }
}
