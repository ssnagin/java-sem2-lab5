package com.ssnagin.lab5java.sem2.lab5.reflection.accessors;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class FieldValueAccessor<T> implements ValueAccessor<T> {
    private static final String INCOMPATIBLE_TYPES_ASSERTION_ERROR = "Accessor's and field's types mismatch: %s is not %s";
    private final Class<T> valueClass;
    private final Field field;

    public FieldValueAccessor(@NonNull Class<T> valueClass, @NonNull Field field) {
        assert valueClass.equals(field.getType()) : String.format(INCOMPATIBLE_TYPES_ASSERTION_ERROR, valueClass, field.getType());
        this.valueClass = valueClass;
        this.field = field;
    }

    @Override
    @SneakyThrows
    public T accessValue(Object object) {
        if (!field.trySetAccessible()) throw new IllegalAccessException(field.getName());
        return valueClass.cast(field.get(object));
    }
}

