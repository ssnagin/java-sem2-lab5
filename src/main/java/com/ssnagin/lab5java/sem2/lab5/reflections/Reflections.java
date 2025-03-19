package com.ssnagin.lab5java.sem2.lab5.reflections;

import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.description.annotations.Description;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Class for Meta-class data manipulation (and more)
 * 
 * @author developer
 */
public final class Reflections {
    
    /**
     * Parses the given model
     * 
     * @param <T>
     * @param type
     * @return
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException 
     */
    public static <T> T parseModel(Class<T> type, Scanner scanner) throws 
            NoSuchMethodException, 
            InstantiationException, 
            IllegalAccessException, 
            IllegalArgumentException, 
            InvocationTargetException {
        
        // Let's start with constructor:
        T instance = type.getDeclaredConstructor().newInstance();
        
        for (Field field : type.getDeclaredFields()) {
            
            if (!field.isAnnotationPresent(Description.class)) continue;
            
            field.setAccessible(true);
            
            Description annotation = field.getAnnotation(Description.class);
            Console.log("Введите " + annotation.name() + " (" + annotation.description() + ") " + field.getAnnotatedType().toString());
            
            Object value = Reflections.parseField(field.getType(), scanner);
            Reflections.setFieldValue(instance, value);
        }
        
        return instance;
    } 
    
    /**
     * Parse field of a collection
     * 
     * @param type
     * @param scanner
     * @return
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException 
     */
    public static Object parseField(Class<?> type, Scanner scanner) throws 
            NoSuchMethodException, 
            InstantiationException, 
            IllegalAccessException, 
            IllegalArgumentException, 
            InvocationTargetException {
        
        if (Reflections.isPrimitive(type)) return Reflections.parsePrimitiveInput(type, scanner);
        
        if (type.isEnum()) return Reflections.parseEnumInput(type, scanner);
        
        return Reflections.parseModel(type, scanner);
    }
    
    /**
     * Clarifies if the given object's type is primitive 
     * 
     * @param clazz
     * @return 
     */
    public static boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive() || 
           clazz == String.class || 
           Number.class.isAssignableFrom(clazz) || 
           Boolean.class.isAssignableFrom(clazz);
    }
    
    public static java.lang.reflect.Method findSetterByParameterName(Class<?> clazz, Class<?> parameterType) {
        for (java.lang.reflect.Method method : clazz.getMethods()) {
            if (method.getName().startsWith("set") && 
                method.getParameterCount() == 1 && 
                method.getParameterTypes()[0].equals(parameterType)) {
                return method;
            }
        }
        return null;
    }
    
    /**
     * Set the value to selected field
     * 
     * @param instance
     * @param value
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException 
     */
    public static void setFieldValue(Object instance, Object value) 
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Class<?> setterClazz = instance.getClass();
        
        java.lang.reflect.Method setter = Reflections.findSetterByParameterName(setterClazz, value.getClass());
        
        
        // exception here 
        setter.invoke(instance, value);
    }
    
    /**
     * Parses string and returns object with type according to the parsedData
     * 
     * @param type
     * @param scanner
     * @return 
     */
    public static Object parsePrimitiveInput(Class<?> type, Scanner scanner) {
        
        Console.print("       | ");
        
        String input = scanner.nextLine().trim();
        
        // VALIDATION HERE | NoT yEt ImPlEmEnTeD!!!!!
        // ex. validatePrimitiveInput()
        
        // Let's Map our statements in order to simplify our life
        Map<Class<?>, Function<String, Object>> parsers = new HashMap<>();
        
        parsers.put(int.class, Integer::parseInt);
        parsers.put(Integer.class, Integer::parseInt);
        parsers.put(long.class, Long::parseLong);
        parsers.put(Long.class, Long::parseLong);
        parsers.put(float.class, Float::parseFloat);
        parsers.put(Float.class, Float::parseFloat);
        parsers.put(double.class, Double::parseDouble);
        parsers.put(Double.class, Double::parseDouble);
        parsers.put(byte.class, Byte::parseByte);
        parsers.put(Byte.class, Byte::parseByte);
        parsers.put(boolean.class, Boolean::parseBoolean);
        parsers.put(Boolean.class, Boolean::parseBoolean);
        parsers.put(String.class, s -> s);
        
        Function<String, Object> parser = parsers.get(type);
        
        return parser.apply(input);
    }
    
    /**
     * Tries to parse enum type
     * 
     * @param type
     * @param scanner
     * @return 
     */
    public static Object parseEnumInput(Class<?> type, Scanner scanner) {
        
        Object[] values = type.getEnumConstants();
        
        Console.separatePrint("Доступные имена: ", "ENUM");
        
        for (Object object : values) {
            Console.println("- " + object);
        }
        
        Console.print("       | ");
        
        String input = scanner.nextLine().trim();
        return Enum.valueOf((Class<? extends Enum>) type, input);
    }
}
