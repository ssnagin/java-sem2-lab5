/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.validation.errors;

/**
 *
 * @author developer
 */
public class ValidationError {
    
    private String fieldName;
    private String message;
    
    public ValidationError(Object object, String message) {
        
        if (object instanceof String) this.fieldName = object.toString();
        this.fieldName = object.getClass().getSimpleName();
        
        this.setMessage(message);
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(Object message) {
        this.message = (String) message;
    }
    
    @Override
    public String toString() {
        return "ValidationError={fieldName=" + 
                this.fieldName + 
                ", message="+this.message+"}";
    }
}
