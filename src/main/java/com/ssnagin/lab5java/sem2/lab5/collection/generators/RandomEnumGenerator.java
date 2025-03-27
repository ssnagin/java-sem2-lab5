package com.ssnagin.lab5java.sem2.lab5.collection.generators;

import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicGenre;

import java.util.Random;

public class RandomEnumGenerator<T extends Enum<T>> {
    private static final Random PRNG = new Random();
    private final T[] values;


    public RandomEnumGenerator(Class<T> e) {
        values = e.getEnumConstants();
    }

    public T randomEnum() {
        return values[PRNG.nextInt(values.length)];
    }
}
