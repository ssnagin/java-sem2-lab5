/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.commands.commands;

import com.ssnagin.lab5java.sem2.lab5.ApplicationStatus;
import com.ssnagin.lab5java.sem2.lab5.commands.Command;
import com.ssnagin.lab5java.sem2.lab5.commands.CommandManager;
import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.console.InputParser;
import com.ssnagin.lab5java.sem2.lab5.console.ParseMode;
import com.ssnagin.lab5java.sem2.lab5.console.ParsedString;

/**
 * Shows brief description about available commands
 * 
 * @author developer
 */
public class CommandExecuteScript extends Command {
    
    private CommandManager commandManager;
    
    public CommandExecuteScript(String name, String description, CommandManager commandManager) {
        super(name, description);
        this.commandManager = commandManager;
    }

    @Override
    public ApplicationStatus executeCommand(ParsedString parsedString) {
        // FOR THE FUTURE:
        // This command requires uri string, so we will have to edit ParsedString to ParseMode.URI !!!
        
        parsedString = InputParser.parse(parsedString.getRowArguments(), ParseMode.COMMAND_ONLY);
        
        // temporary solution without reading files
        
        Console.log(parsedString);
        
        Command command = this.commandManager.get(parsedString.getCommand());
        
        return command.executeCommand(parsedString);
    }
}
