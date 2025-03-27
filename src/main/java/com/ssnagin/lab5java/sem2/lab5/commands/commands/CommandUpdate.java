/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.commands.commands;

import com.ssnagin.lab5java.sem2.lab5.ApplicationStatus;
import com.ssnagin.lab5java.sem2.lab5.collection.CollectionManager;
import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import com.ssnagin.lab5java.sem2.lab5.commands.Command;
import com.ssnagin.lab5java.sem2.lab5.commands.CommandManager;
import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.console.ParsedString;
import com.ssnagin.lab5java.sem2.lab5.description.DescriptionParser;
import com.ssnagin.lab5java.sem2.lab5.reflection.Reflections;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author developer
 */
public class CommandUpdate extends Command {

    private CollectionManager collectionManager;
    private CommandManager commandManager;
    private Scanner scanner;
    
    public CommandUpdate(String name, 
            String description, 
            CollectionManager collectionManager,
            Scanner scanner,
            CommandManager commandManager) {
        super(name, description);
        
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
        this.scanner = scanner;
    }

    @Override
    public ApplicationStatus executeCommand(ParsedString parsedString) {
       
//        this.collectionManager.addElement(new LocalDateWrapper(new MusicBand(
//            1,
//            "test", 
//            new Coordinates((long) 28, 1),
//            1L, 
//            1,
//            MusicGenre.MATH_ROCK,
//            new Album("Test", (long) 123)
//        )));
        
        if (!parsedString.getArguments().isEmpty()) {
            if ("h".equals(parsedString.getArguments().getFirst()))
                return this.showUsage(parsedString);
        }
        
        Long id;
        
        // Try to parse Integer
        // VALIDATOR HERE

        try {
            id = (Long) Reflections.parsePrimitiveInput(
                    Long.class, 
                    parsedString.getArguments().getFirst()
            );
        } catch (NumberFormatException ex) {
            Console.log("Неверный формат числа");
            return ApplicationStatus.RUNNING;
        } catch (IndexOutOfBoundsException ex) {
            return this.showUsage(parsedString);
        }
         
        
        MusicBand musicBand = this.collectionManager.getElementById(id);
        
        if (musicBand == null) {
            Console.log("Коллекции по заданому id не существует");
            return ApplicationStatus.RUNNING;
        }
        
        /*
        TEMPORARY CREATED SOLUTION!!!!
        
        That's how it should be propperly handled:
        
        For command update <id> <field> <value>
        1. Get MusicBand model
        2. Parse given field and value 
        3. Call right setter
        
        For command update <id>
        
        Soluion below   ||
                        \/
        */
        
        parsedString.setCommand("add");
        
        Command command = this.commandManager.get(parsedString.getCommand());
        ApplicationStatus status = command.executeCommand(parsedString);
        
        if (status != ApplicationStatus.RUNNING) return status;
        
        MusicBand elementToChange = this.collectionManager.getElementById(id);
        
        // Check if the collection was not added:
        if (elementToChange == null) {
            Console.error("Something went wrong while adding element to collection!");
            return ApplicationStatus.RUNNING;
        }
        
        elementToChange.setId(id);
        
        parsedString.setCommand("remove_by_id");
        
        command = this.commandManager.get(parsedString.getCommand());
        return command.executeCommand(parsedString);
    }
    
    @Override
    public ApplicationStatus showUsage(ParsedString parsedString) {
        
        StringBuilder stringBuilder = new StringBuilder();
      
        stringBuilder.append("usage: update <id> <field> <value>\n").append("things that can be updated:\n");
        stringBuilder.append(DescriptionParser.getRecursedDescription(MusicBand.class, new HashMap<>()));
        
        Console.println(stringBuilder);
        
        return ApplicationStatus.RUNNING;
    }
}