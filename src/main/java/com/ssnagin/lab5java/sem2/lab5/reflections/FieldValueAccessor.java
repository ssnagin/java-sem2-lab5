package com.ssnagin.lab5java.sem2.lab5.reflections;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class FieldValueAccessor<T> implements ValueAccessor<T> {

    @Override
    @SneakyThrows
    public T accessValue(Field field, Object object) {
        if(field.trySetAccessible())
            return (T)field.get(object); // GOVNO!
        else {
            throw new IllegalAccessException(field.getName());
        }
    }
}

