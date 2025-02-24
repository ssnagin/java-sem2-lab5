/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.inputParser;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author developer
 */
@ToString
@EqualsAndHashCode
public class ParsedString {
    
    private String command = "";
    private List<String> arguments;
    
    public ParsedString(String command, String arguments) {
        this();
    }
    
    public ParsedString() {
        this.arguments = new ArrayList<>();

    }
    
    public void setCommand(String command) {
        this.command = command;
    }
    
    public String getCommand() {
        return this.command;
    }
    
    public List<String> getArguments() {
        return this.arguments;
    }
    
    public void addArgument(String argument) {
        this.arguments.add(argument);
    }
    
    public void addFromStream(String someText) {
        if (someText == null) return;
        
        if (!(this.getCommand().equals(""))) {
            this.addArgument(someText); 
            return;
        }
        
        this.setCommand(someText);
    }
    
    public boolean isEmpty() {
        return this.getCommand() == null || this.getCommand().equals("");
    }
}
