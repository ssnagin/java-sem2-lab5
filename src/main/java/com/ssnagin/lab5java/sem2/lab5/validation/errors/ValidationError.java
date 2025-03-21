/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.validation.errors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author developer
 */
@Getter
@Setter
@ToString
public class ValidationError {
    
    private String fieldName;
    private String message;
    
    public ValidationError(Object object, String message) {
        
        if (object instanceof String) this.fieldName = object.toString();
        this.fieldName = object.getClass().getSimpleName();
        
        this.setMessage(message);
    }
    
    public boolean isEmpty() {
        return fieldName == null && message == null;
    }
}
