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
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author developer
 */
@ToString
@EqualsAndHashCode
public class Core {
    
    private CollectionManager collectionManager;
    private CommandManager commandManager;
    private ValidationController validationController;
    private InputParser inputParser;
    private Console console;
    
    ApplicationStatus applicationStatus;
    
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
        
        this.setApplicationStatus(ApplicationStatus.RUNNING);
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
                
                Console.print(console.getShellArrow());
                
                parsedString = InputParser.parse(scanner.nextLine());
                
                // 1.1 If the string is null, skip the code:

                if (parsedString.isEmpty()) {
                    // ... some code
                    continue;
                }
                
                // 2 Executing commands according to user's input\
                this.execute(parsedString);
                
            } catch (NullPointerException exception) {
                Console.error(exception);
            }
        }
    }
    
    public void printLogo() {
        Console.print(Core.ASCII_LOGO);
    }
    
    private void execute(ParsedString parsedString) {
        
        // 0. check if command is exiting:
        
        if (parsedString.getCommand().equals("exit")) {
            this.setApplicationStatus(ApplicationStatus.EXIT);
        }
    }
    
    private void setApplicationStatus(ApplicationStatus applicationStatus) {

        this.applicationStatus = applicationStatus;
        
        if (applicationStatus != ApplicationStatus.RUNNING) {
            this.onExit();
        }
    }
    
    public ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }
    
    // === EVENTS ==== //
    
    public void onExit() {
        // Some code here, for example saving json.
        
        Console.separatePrint("Bye, have a great time!", this.getApplicationStatus().toString());
        System.exit(this.getApplicationStatus().getCode());
    }
}
