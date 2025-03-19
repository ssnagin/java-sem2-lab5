/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.console;

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
    
    private String pureString;
    
    private String command;
    private List<String> arguments;
    
    public ParsedString(String pureString, String command, List<String> arguments) {
        this(pureString);
        
        this.setCommand(command);
        this.addArguments(arguments);
    }
    
    public ParsedString() {
        this("");
    }
    
    public ParsedString(String pureString) {
        this.setPureString(pureString); 
        
        this.command = "";
        this.arguments = new ArrayList<>();
    }
    
    public void setCommand(String command) {
        this.command = command.toLowerCase();
    }
    
    public String getCommand() {
        return this.command;
    }
    
    public String getPureString() {
        return this.pureString;
    }
    
    public List<String> getArguments() {
        return this.arguments;
    }
    
    public String getRowArguments() {
        StringBuilder stringBuilder = new StringBuilder();
        
        for (String element : this.arguments) {
            stringBuilder.append(element);
        }
        
        return stringBuilder.toString();
    }
    
    public void addArgument(String argument) {
        if (this.getArguments().isEmpty())
            argument = argument.stripLeading();
        
        this.arguments.add(argument);
    }
    
    public void addArguments(List<String> arguments) {
        for (String argument : arguments) {
            this.addArgument(argument);
        }
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
        return this.getPureString().isEmpty() || this.getCommand() == null || this.getCommand().isEmpty();
    }

    private void setPureString(String pureString) {
        this.pureString = pureString;
    }
}
