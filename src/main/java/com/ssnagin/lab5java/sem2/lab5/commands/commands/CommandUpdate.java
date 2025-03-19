/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.commands.commands;

import com.ssnagin.lab5java.sem2.lab5.ApplicationStatus;
import com.ssnagin.lab5java.sem2.lab5.collection.CollectionManager;
import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import com.ssnagin.lab5java.sem2.lab5.commands.Command;
import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.console.ParsedString;
import com.ssnagin.lab5java.sem2.lab5.description.DescriptionParser;
import com.ssnagin.lab5java.sem2.lab5.reflections.Reflections;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author developer
 */
public class CommandUpdate extends Command {

    CollectionManager collectionManager;
    Scanner scanner;
    
    public CommandUpdate(String name, 
            String description, 
            CollectionManager collectionManager,
            Scanner scanner) {
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
        
        Long id;
        
        // Try to parse Integer
        // VALIDATOR HERE
        try {
            id = Long.parseLong(parsedString.getArguments().get(0));
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
        1. Get MusicBand model
        2. 
        */
        
        return ApplicationStatus.RUNNING;
    }
    
    @Override
    public ApplicationStatus showUsage(ParsedString parsedString) {
        
        StringBuilder stringBuilder = new StringBuilder();
      
        stringBuilder.append("usage: update <id> ...\n").append("things that can be updated:\n");
        stringBuilder.append(DescriptionParser.getRecursedDescription(MusicBand.class, new HashMap<>()));
        
        Console.println(stringBuilder);
        
        return ApplicationStatus.RUNNING;
    }
}