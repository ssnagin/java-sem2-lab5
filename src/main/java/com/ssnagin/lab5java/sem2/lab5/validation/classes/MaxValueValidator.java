/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.validation.classes;

import com.ssnagin.lab5java.sem2.lab5.validation.AnnotationValidator;
import com.ssnagin.lab5java.sem2.lab5.validation.ValidationError;
import com.ssnagin.lab5java.sem2.lab5.validation.annotations.MaxValue;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author developer
 */
public class MaxValueValidator<T extends Comparable<T>> extends AnnotationValidator<T> {
    
    private final T maxValue;
    
    public MaxValueValidator(T maxValue) {
        this.maxValue = maxValue;
    }
    
    @Override
    public List<ValidationError> validate(T object) {
        
        // gpt какую-то фигню сгенерил, переделать тут всё
        List<ValidationError> errors = new ArrayList<>();

        // Получаем все поля класса
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {

            if (field.isAnnotationPresent(MaxValue.class)) {
                MaxValue maxValueAnnotation = field.getAnnotation(MaxValue.class);
                long maxValue = maxValueAnnotation.maxValue(); // Получаем максимальное значение
                String showMessage = maxValueAnnotation.showMessage(); // Получаем сообщение

                field.setAccessible(true); // Делаем поле доступным
                try {
                    Object value = field.get(object); // Получаем значение поля
                    if (value instanceof Number) {
                        long fieldValue = ((Number) value).longValue(); // Приводим к long
                        if (fieldValue > maxValue) {
                            // Формируем сообщение об ошибке
                            String message = showMessage.replace("{value}", String.valueOf(maxValue));
                            errors.add(new ValidationError(field.getName(), message));
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace(); // Обработка исключения
                }
            }
        }

        return errors; // Возвращаем список ошибок
    }
}
