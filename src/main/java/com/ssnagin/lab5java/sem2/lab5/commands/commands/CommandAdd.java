/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.commands.commands;

import com.ssnagin.lab5java.sem2.lab5.ApplicationStatus;
import com.ssnagin.lab5java.sem2.lab5.collection.CollectionManager;
import com.ssnagin.lab5java.sem2.lab5.commands.Command;
import com.ssnagin.lab5java.sem2.lab5.console.ParsedString;
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
        
        scanner.nextLine();
        
        return ApplicationStatus.RUNNING;
    }
}
