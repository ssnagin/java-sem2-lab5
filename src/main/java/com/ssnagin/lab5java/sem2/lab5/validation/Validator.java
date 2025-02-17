/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.validation;

import java.util.List;

/**
 *
 * @author developer
 */
public interface Validator<T> {
    
    public List<ValidationError> validate(T object);
}
