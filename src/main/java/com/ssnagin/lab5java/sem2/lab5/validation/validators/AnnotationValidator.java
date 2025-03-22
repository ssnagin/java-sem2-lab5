///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.ssnagin.lab5java.sem2.lab5.validation.validators;
//
//import com.ssnagin.lab5java.sem2.lab5.reflections.Reflections;
//import com.ssnagin.lab5java.sem2.lab5.validation.ValidationError;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//
///**
// *
// * @author developer
// * @param <A>
// */
//public abstract class AnnotationValidator<A extends Annotation> implements Validator {
//    
//    // I got the idea, this code should be replaced
//    
//    @Override
//    public ValidationError validate(Field field, Object object) {
//        
//        A annotation = getAnnotation(getAnnotationClass(), field);
//        
//        // Temporary
//        if (annotation == null) return null;
//        //
//        if (annotation == null) return new ValidationError("AnnotationValidator", "Annotation was not found in the field");
//        
//        return validateField(annotation, field,  object);
//    }
//    
//    public abstract ValidationError validateField(A annotation, Field field, Object object);
//    
//    public abstract Class<A> getAnnotationClass();
//    
//    public boolean isValid(Field field, Object object) {
//        return validate(field, object).isEmpty();
//    }
//    
//    public static <T extends Annotation> T getAnnotation(Class<T> annotation, Field field) {
//        return Reflections.getAnnotation(annotation, field);
//    }
//}
