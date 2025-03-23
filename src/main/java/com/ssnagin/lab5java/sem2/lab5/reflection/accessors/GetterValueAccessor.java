package com.ssnagin.lab5java.sem2.lab5.reflection.accessors;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetterValueAccessor<T> implements ValueAccessor<T> {
    public static final String GETTER_NAME_PATTERN = "get%s";
    private static final String INCOMPATIBLE_GETTER_TYPE_ASSERTION_ERROR = "Accessor's and getter's types mismatch: %s is not %s";
    private final Class<T> valueClass;
    private final Method valueGetter;

    @SneakyThrows
    public GetterValueAccessor(Class<T> valueClass, Field field) {
        this.valueClass = valueClass;
        Class<?> objectClass = field.getDeclaringClass();
        String getterName = objectClass.isRecord() ? field.getName() : String.format(GETTER_NAME_PATTERN, StringUtils.capitalize(field.getName()));
        valueGetter = objectClass.getMethod(getterName);
        assert valueClass.equals(valueGetter.getReturnType()) : String.format(INCOMPATIBLE_GETTER_TYPE_ASSERTION_ERROR, valueClass, valueGetter.getReturnType());
    }

    @Override
    @SneakyThrows
    public T accessValue(Object object) {
        return valueClass.cast(valueGetter.invoke(object));
    }
}
