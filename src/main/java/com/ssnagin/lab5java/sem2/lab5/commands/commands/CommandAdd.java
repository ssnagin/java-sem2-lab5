/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.commands.commands;

import com.ssnagin.lab5java.sem2.lab5.ApplicationStatus;
import com.ssnagin.lab5java.sem2.lab5.collection.CollectionManager;
import com.ssnagin.lab5java.sem2.lab5.collection.annotations.Description;
import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import com.ssnagin.lab5java.sem2.lab5.commands.Command;
import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.console.ParsedString;
import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * Shows brief description about available commands
 * 
 * @author developer
 */
public class CommandAdd extends Command {
    
    public CollectionManager collectionManager;
    
    public CommandAdd(String name, String description, CollectionManager collectionManager) {
        super(name, description);
        
        this.collectionManager = collectionManager;
    }

    @Override
    public ApplicationStatus execute(ParsedString parsedString) {
        
        Scanner scanner = new Scanner(System.in);
        
        StringBuilder test = new StringBuilder();
        
        Console.separatePrint("Please, fill in the form with your values:", this.getName().toUpperCase());
        
        for (Field field : MusicBand.class.getDeclaredFields()) {
            
            // If a field does not contain @Description, skip
            
            if (!field.isAnnotationPresent(Description.class)) {
                continue;
            }
                        
            // Make it accessible
            
            field.setAccessible(true);
            
            Description annotation = field.getAnnotation(Description.class);
            
            Console.log("Введите " + annotation.name() + "(" + annotation.description() + ")");
            
            if (isPrimitive(field.getType())) {
                
                test.append(scanner.nextLine());
                
                // Recursion here...
                
                // Console.log(field.toString());
                
            }
            
            field.setAccessible(false);
        }
        
        return ApplicationStatus.RUNNING;
    }
    
    private static boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive() || 
               clazz == String.class || 
               Number.class.isAssignableFrom(clazz) || 
               Boolean.class.isAssignableFrom(clazz);
    }

}
