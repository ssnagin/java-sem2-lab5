/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.inputParser;

/**
 * Module that is responsible for parsing user's input
 * 
 * @author developer
 */
public class InputParser {
    
    private final String ARGUMENT_STRING = "[A-Za-z]{0}(\\\\\\\".{0,}\\\\\\\"|\\\\w{0,})";
    
    public static ParsedString parse(Object text) {
        
        ParsedString result;
        
        if (text.equals(null)) return null;
        
//        try {
//            
//        } catch() {
//            
//        }

        result = new ParsedString();
        return result;
    }
}
