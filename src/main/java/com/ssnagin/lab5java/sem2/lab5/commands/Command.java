/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.commands;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * A basic class that defines all commands
 * @author developer
 */
@EqualsAndHashCode
@ToString
public abstract class Command {
    
    private String name;
    private String description;
    
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
}
