/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.commands.commands;

import com.ssnagin.lab5java.sem2.lab5.ApplicationStatus;
import com.ssnagin.lab5java.sem2.lab5.collection.CollectionManager;
import com.ssnagin.lab5java.sem2.lab5.description.annotations.Description;
import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import com.ssnagin.lab5java.sem2.lab5.collection.wrappers.LocalDateWrapper;
import com.ssnagin.lab5java.sem2.lab5.commands.Command;
import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.console.ParsedString;
import com.ssnagin.lab5java.sem2.lab5.description.DescriptionParser;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Shows brief description about available commands
 * 
 * @author developer
 */
public class CommandAdd extends Command {
    
    public CollectionManager collectionManager;
    private final Scanner scanner;
    
    public CommandAdd(String name, String description, CollectionManager collectionManager, Scanner scanner) {
        super(name, description);

        this.collectionManager = collectionManager;
        this.scanner = scanner;
    }

    @Override
    public ApplicationStatus executeCommand(ParsedString parsedString) {
        
        if (!parsedString.getArguments().isEmpty()) {
            if (" h".equals(parsedString.getArguments().get(0))) 
                return this.showUsage(parsedString);
        }
        
        StringBuilder test = new StringBuilder();
        
        Console.separatePrint("Please, fill in the form with your values:", this.getName().toUpperCase());
        
        try {
            var result = new LocalDateWrapper(
                    parseModel(MusicBand.class)
            );
                    
            Console.log(result.toString());
            Console.log(result.getName());
            
            // Final validation here;
            
            // Adding into CollectionManager with Creation Date:
            this.collectionManager.addElement(result);
            
            Console.separatePrint("Successfully added!", "SUCCESS");
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Console.error(ex.toString());
        }
        
        return ApplicationStatus.RUNNING;
    }
    
    
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
    private <T> T parseModel(Class<T> type) throws 
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
            
            Object value = parseField(field.getType());
            setFieldValue(instance, field.getName(), value);
        }
        
        return instance;
    } 
    
    private Object parseField(Class<?> type) throws 
            NoSuchMethodException, 
            InstantiationException, 
            IllegalAccessException, 
            IllegalArgumentException, 
            InvocationTargetException {
        
        if (isPrimitive(type)) return parsePrimitiveInput(type);
        
        if (type.isEnum()) return parseEnumInput(type);
        
        return parseModel(type);
    }
    
    private Object parsePrimitiveInput(Class<?> type) {
        
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
    
    private Object parseEnumInput(Class<?> type) {
        
        Object[] values = type.getEnumConstants();
        
        Console.separatePrint("Доступные имена: ", "ENUM");
        
        for (Object object : values) {
            Console.println("- " + object);
        }
        
        String input = scanner.nextLine().trim();
        return Enum.valueOf((Class<? extends Enum>) type, input);
    }
    
    private void setFieldValue(Object instance, String fieldName, Object value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String preparedSetter = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1).toLowerCase();
        
        Class<?> setterClazz = instance.getClass();
        
        // exception here
        java.lang.reflect.Method setter = findSetterByParameterName(setterClazz, value.getClass());
        
        // exception here
//        java.lang.reflect.Method setter = setterClazz.getMethod(preparedSetter, value.getClass());
        
        // exception here too 
        setter.invoke(instance, value);
    }
    
    private java.lang.reflect.Method findSetterByParameterName(Class<?> clazz, Class<?> parameterType) {
        for (java.lang.reflect.Method method : clazz.getMethods()) {
            if (method.getName().startsWith("set") && 
                method.getParameterCount() == 1 && 
                method.getParameterTypes()[0].equals(parameterType)) {
                return method;
            }
        }
        return null;
    }
    
    @Override
    public ApplicationStatus showUsage(ParsedString parsedString) {
        Console.println("Список того, что надо ввести:");
        Console.println(DescriptionParser.getRecursedDescription(MusicBand.class, new HashMap<>()));
        
        return ApplicationStatus.RUNNING;
    }
    
    private static boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive() || 
               clazz == String.class || 
               Number.class.isAssignableFrom(clazz) || 
               Boolean.class.isAssignableFrom(clazz);
    }
}
