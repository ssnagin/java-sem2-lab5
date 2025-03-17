/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5;

import com.ssnagin.lab5java.sem2.lab5.console.InputParser;
import com.ssnagin.lab5java.sem2.lab5.collection.CollectionManager;
import com.ssnagin.lab5java.sem2.lab5.commands.Command;
import com.ssnagin.lab5java.sem2.lab5.commands.CommandManager;
import com.ssnagin.lab5java.sem2.lab5.commands.commands.CommandAdd;
import com.ssnagin.lab5java.sem2.lab5.commands.commands.CommandClear;
import com.ssnagin.lab5java.sem2.lab5.commands.commands.CommandExecuteScript;
import com.ssnagin.lab5java.sem2.lab5.commands.commands.CommandExit;
import com.ssnagin.lab5java.sem2.lab5.commands.commands.CommandHelp;
import com.ssnagin.lab5java.sem2.lab5.commands.commands.CommandShow;
import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.console.ParseMode;
import com.ssnagin.lab5java.sem2.lab5.console.ParsedString;
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
    private InputParser inputParser;
    private Console console;
    
    private Scanner scanner;
    
    ApplicationStatus applicationStatus;
    public static final String ASCII_LOGO = " ▗▄▄▖ ▄▄▄  █ █ ▗▞▀▚▖▗▞▀▘   ■  ▄  ▄▄▄  ▄▄▄▄  ▗▖  ▗▖▗▞▀▜▌▄▄▄▄  ▗▞▀▜▌     ▗▞▀▚▖ ▄▄▄ \n" +
                                            "▐▌   █   █ █ █ ▐▛▀▀▘▝▚▄▖▗▄▟▙▄▖▄ █   █ █   █ ▐▛▚▞▜▌▝▚▄▟▌█   █ ▝▚▄▟▌     ▐▛▀▀▘█    \n" +
                                            "▐▌   ▀▄▄▄▀ █ █ ▝▚▄▄▖      ▐▌  █ ▀▄▄▄▀ █   █ ▐▌  ▐▌     █   █           ▝▚▄▄▖█    \n" +
                                            "▝▚▄▄▖      █ █            ▐▌  █             ▐▌  ▐▌                 ▗▄▖           \n" +
                                            "                          ▐▌                                      ▐▌ ▐▌          \n" +
                                            "                                                                   ▝▀▜▌          \n" +
                                            "  ver. 1.0 | github.com/ssnagin/java-sem2-lab5.git                ▐▙▄▞▘        \n\n";
    
    public Core() {
        // Singletone pattern
        this.collectionManager = CollectionManager.getInstance();
        this.commandManager = CommandManager.getInstance();
        
        this.inputParser = new InputParser();
        this.scanner = new Scanner(System.in);
        
        registerCommands();
        
        this.setApplicationStatus(ApplicationStatus.RUNNING);
    }
    
    private void registerCommands() {
        this.commandManager.register(new CommandExit("exit", "exit this useless piece of masterpiece"));
        this.commandManager.register(new CommandHelp("help", "display help on available commands", commandManager));
        this.commandManager.register(new CommandExecuteScript("execute_script", "some description here", commandManager));
        this.commandManager.register(new CommandAdd("add", "add an object to collection", collectionManager, scanner));
        this.commandManager.register(new CommandShow("show", "show collection's elements", collectionManager));
        this.commandManager.register(new CommandClear("clear", "clear collection elements"));
    }

    public void start() {
        
        // Step-by-step description of the algorithm.
        
        // 0. First, print logo
        
        this.printLogo();
        
        // 1. Wait for the user input. 
        // After it, parse given arguments with ArgumentParser
        
        Scanner scanner = new Scanner(System.in);
        ParsedString parsedString;
        
        while (true) {
            
            Console.print(Console.getShellArrow());
            
            // I need to replace this code for the future custom input (executeCommand from script) integration.
            

            parsedString = new ParsedString(scanner.nextLine());
            
            parsedString = InputParser.parse(parsedString.getPureString(), ParseMode.COMMAND_ONLY);

            // 1.1 If the string is null, skip the code:

            if (parsedString.isEmpty()) {
                // ... some code
                continue;
            }

            // 2 Executing commands according to user's input
            this.runCommand(parsedString);
        }
    }
    
    public void printLogo() {
        Console.print(Core.ASCII_LOGO);
    }
    
    private void runCommand(ParsedString parsedString) {

        Command command = this.commandManager.get(parsedString.getCommand());
        this.setApplicationStatus(command.executeCommand(parsedString));
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