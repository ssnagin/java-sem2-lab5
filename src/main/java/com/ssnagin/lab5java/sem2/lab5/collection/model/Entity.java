/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.collection.model;

import com.ssnagin.lab5java.sem2.lab5.collection.annotations.Description;
import com.ssnagin.lab5java.sem2.lab5.collection.interfaces.Describable;
import java.lang.reflect.Field;

/**
 *
 * @author developer
 */
public abstract class Entity<T> implements Describable, Comparable<T> {
    
    public abstract int compareTo(T object);
    
    /**
     * Shows description according to provided info in @Description
     * @return 
     */
    public String getDescription() {
        Field[] fields = Entity.class.getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("Объекты ").append(
                this.getClass().getCanonicalName()).append(":");
        
        for (Field field : fields) {
            field.setAccessible(true);
            if (!(field.isAnnotationPresent(Description.class))) continue;
                      
            Description description = field.getAnnotation(Description.class);
            
            stringBuilder
                    .append(" - ").append(description.name()).append("{")
                    .append(field.getName())
                    .append("}")
                    .append("\t\t").append(description.description());
            
            field.setAccessible(false);
        }
        
        return stringBuilder.toString();
    }
}
