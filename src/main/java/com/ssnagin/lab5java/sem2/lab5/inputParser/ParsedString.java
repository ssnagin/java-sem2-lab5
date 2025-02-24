/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.inputParser;

import java.util.List;

/**
 *
 * @author developer
 */
public class ParsedString {
    
    private String command = null;
    private List<String> arguments = null;
    
    public ParsedString(String command, String arguments) {
        
    }
    
    public ParsedString() {
        
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
    
    public boolean isEmpty() {
        return this.getCommand().equals(null) || this.getCommand().equals("");
    }
}
