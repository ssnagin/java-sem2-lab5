/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.validation;

import com.ssnagin.lab5java.sem2.lab5.validation.errors.ValidationError;
import java.util.ArrayList;
import java.util.List;

/**
 * Validates 
 * @author developer
 */
public class ValidationController {
    public List<ValidationError> validate(Object object) {
        List<ValidationError> errors;
        
        // о ужас, ошибки
        errors = new ArrayList<>();
        
        return errors.isEmpty() ? errors : null;
    }
}
