/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.commands;

import com.ssnagin.lab5java.sem2.lab5.ApplicationStatus;
import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.console.ParsedString;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * A basic class that defines all commands
 * @author developer
 */
@EqualsAndHashCode
@ToString
public abstract class Command implements Comparable<Command> {
    
    private String name;
    public String description;

    public Command(String name, String description) {
        this.setName(name);
        this.setDescription(description);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public abstract ApplicationStatus executeCommand(ParsedString parsedString);
    
    public ApplicationStatus showUsage(ParsedString parsedString) {
        
        Console.log("Usage not implemented: " + parsedString.toString());
        
        return ApplicationStatus.RUNNING;
    }

    public int compareTo(Command otherCommand) {
        
        int result = this.getName().compareTo(otherCommand.getName());
        
        if (result == 0) this.getDescription().compareTo(otherCommand.getDescription());
        
        return result;
    }

    
}
