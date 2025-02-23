/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5;

import com.ssnagin.lab5java.sem2.lab5.inputParser.InputParser;
import com.ssnagin.lab5java.sem2.lab5.collection.CollectionManager;
import com.ssnagin.lab5java.sem2.lab5.commands.CommandManager;
import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.inputParser.ParsedString;
import com.ssnagin.lab5java.sem2.lab5.validation.ValidationController;
import java.util.Scanner;

/**
 * 
 * @author developer
 */
public class Core {
    
    CollectionManager collectionManager;
    CommandManager commandManager;
    ValidationController validationController;
    InputParser inputParser;
    Console console;
    
    public static final String ASCII_LOGO = " ▗▄▄▖ ▄▄▄  █ █ ▗▞▀▚▖▗▞▀▘   ■  ▄  ▄▄▄  ▄▄▄▄  ▗▖  ▗▖▗▞▀▜▌▄▄▄▄  ▗▞▀▜▌     ▗▞▀▚▖ ▄▄▄ \n" +
                                            "▐▌   █   █ █ █ ▐▛▀▀▘▝▚▄▖▗▄▟▙▄▖▄ █   █ █   █ ▐▛▚▞▜▌▝▚▄▟▌█   █ ▝▚▄▟▌     ▐▛▀▀▘█    \n" +
                                            "▐▌   ▀▄▄▄▀ █ █ ▝▚▄▄▖      ▐▌  █ ▀▄▄▄▀ █   █ ▐▌  ▐▌     █   █           ▝▚▄▄▖█    \n" +
                                            "▝▚▄▄▖      █ █            ▐▌  █             ▐▌  ▐▌                 ▗▄▖           \n" +
                                            "                          ▐▌                                      ▐▌ ▐▌          \n" +
                                            "                                                                   ▝▀▜▌          \n" +
                                            "  ver. 1.0 | github.com/ssnagin/java-sem2-lab5.git                ▐▙▄▞▘        \n\n";
    
    public Core() {
        this.collectionManager = new CollectionManager();
        this.commandManager = new CommandManager();
        this.validationController = new ValidationController();
        this.inputParser = new InputParser();
        this.console = new Console();   
    }

    public void run() {
        
        // Step-by-step description of the algorithm.
        
        // 0. First, print logo
        
        this.printLogo();
        
        // 1. Wait for the user input. 
        // After it, parse given arguments with ArgumentParser
        
        Scanner scanner = new Scanner(System.in);
        ParsedString parsedString;
        
        while (true) {
            try {
                System.out.print(console.getShellArrow());
                
                parsedString = InputParser.parse(scanner.nextLine());
                
                // 1.1 If the string is null, skip the code:
                if (parsedString.isEmpty()) {
                    // ... some code
                    continue;
                }
                
                if (parsedString.equals("exit")) {
                    // ... some code
                    // ...and exit!
                    break;
                }
                
            } catch (Exception exception) {
                Console.error(exception);
            }
        }
    }
    
    public void printLogo() {
        Console.print(this.ASCII_LOGO);
    }
}
