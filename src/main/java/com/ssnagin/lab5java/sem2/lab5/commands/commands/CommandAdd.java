/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.commands.commands;

import com.ssnagin.lab5java.sem2.lab5.reflections.Reflections;
import com.ssnagin.lab5java.sem2.lab5.ApplicationStatus;
import com.ssnagin.lab5java.sem2.lab5.collection.CollectionManager;
import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import com.ssnagin.lab5java.sem2.lab5.collection.wrappers.LocalDateWrapper;
import com.ssnagin.lab5java.sem2.lab5.commands.Command;
import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.console.ParsedString;
import com.ssnagin.lab5java.sem2.lab5.description.DescriptionParser;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Shows brief description about available commands
 * 
 * @author developer
 */
public class CommandAdd extends Command {
    
    private CollectionManager collectionManager;
    private final Scanner scanner;
    
    public CommandAdd(String name, String description, CollectionManager collectionManager, Scanner scanner) {
        super(name, description);

        this.collectionManager = collectionManager;
        this.scanner = scanner;
    }

    @Override
    public ApplicationStatus executeCommand(ParsedString parsedString) {
        
        if (!parsedString.getArguments().isEmpty()) {
            if (" h".equals(parsedString.getArguments().get(0))) 
                return this.showUsage(parsedString);
        }
        
        Console.separatePrint("Please, fill in the form with your values:", this.getName().toUpperCase());
        
        try {
            var result = new LocalDateWrapper(
                    Reflections.parseModel(MusicBand.class, scanner)
            );
            
            // Final validation here;
            
            // Adding into CollectionManager with Creation Date:
            this.collectionManager.addElement(result);
            
            Console.separatePrint("Successfully added!", "SUCCESS");
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Console.error(ex.toString());
        }
        
        return ApplicationStatus.RUNNING;
    }
    
    @Override
    public ApplicationStatus showUsage(ParsedString parsedString) {
        Console.println("Usage: add\nСписок того, что надо ввести:");
        Console.println(DescriptionParser.getRecursedDescription(MusicBand.class, new HashMap<>()));
        
        return ApplicationStatus.RUNNING;
    }
}
