package com.ssnagin.lab5java.sem2.lab5.reflections;

import java.lang.reflect.Field;

public interface ValueAccessor<T> {
    T accessValue(Field field, Object object);
}

