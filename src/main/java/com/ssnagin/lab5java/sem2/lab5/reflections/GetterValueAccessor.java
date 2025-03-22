package com.ssnagin.lab5java.sem2.lab5.reflections;

import java.lang.reflect.Field;

public class GetterValueAccessor<T> implements ValueAccessor<T> {
    public static final String GETTER_NAME_PATTERN = "get%s";

    /**
     *
     * @param field
     * @param object
     * @return
     */
    @Override
    public T accessValue(Field field, Object object) {
        String getterName = String.format(String. field.getName());
    }
}
