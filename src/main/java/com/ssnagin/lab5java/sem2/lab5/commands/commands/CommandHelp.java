/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.commands.commands;

import com.ssnagin.lab5java.sem2.lab5.ApplicationStatus;
import com.ssnagin.lab5java.sem2.lab5.commands.Command;

/**
 * Shows brief description about available commands
 * 
 * @author developer
 */
public class CommandHelp extends Command {
    
    public CommandHelp(String name, String description) {
        super(name, description);
    }

    @Override
    public ApplicationStatus execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
