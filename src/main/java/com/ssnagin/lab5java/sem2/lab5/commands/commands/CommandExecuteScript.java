/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.commands.commands;

import com.google.gson.GsonBuilder;
import com.ssnagin.lab5java.sem2.lab5.ApplicationStatus;
import com.ssnagin.lab5java.sem2.lab5.collection.CollectionManager;
import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import com.ssnagin.lab5java.sem2.lab5.commands.Command;
import com.ssnagin.lab5java.sem2.lab5.commands.CommandManager;
import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.console.InputParser;
import com.ssnagin.lab5java.sem2.lab5.console.ParseMode;
import com.ssnagin.lab5java.sem2.lab5.console.ParsedString;
import com.ssnagin.lab5java.sem2.lab5.files.FileManager;
import com.ssnagin.lab5java.sem2.lab5.files.adapters.LocalDateAdapter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.TreeSet;

/**
 * Shows brief description about available commands
 * 
 * @author developer
 */
public class CommandExecuteScript extends Command {
    
    private CommandManager commandManager;
    private CollectionManager collectionManager;
    
    public CommandExecuteScript(String name, String description, CommandManager commandManager, CollectionManager collectionManager) {
        super(name, description);
        this.commandManager = commandManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public ApplicationStatus executeCommand(ParsedString parsedString) {
        // FOR THE FUTURE:
        // This command requires uri string, so we will have to edit ParsedString to ParseMode.URI !!!
        
        parsedString = InputParser.parse(parsedString.getRowArguments(), ParseMode.COMMAND_ONLY);


        /*
        TreeSet<MusicBand> test = null;
        try {
            test = FileManager.getInstance().read("ttt.json");
            this.collectionManager.setCollection(test);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Console.println(test);

        return ApplicationStatus.RUNNING;

        */
        // temporary solution without reading files
        //Console.log(parsedString);
        //Command command = this.commandManager.get(parsedString.getCommand());
        //return command.executeCommand(parsedString);
    }
}
