/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5;

import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import com.ssnagin.lab5java.sem2.lab5.commands.commands.*;
import com.ssnagin.lab5java.sem2.lab5.console.InputParser;
import com.ssnagin.lab5java.sem2.lab5.collection.CollectionManager;
import com.ssnagin.lab5java.sem2.lab5.commands.Command;
import com.ssnagin.lab5java.sem2.lab5.commands.CommandManager;
import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.console.ParseMode;
import com.ssnagin.lab5java.sem2.lab5.console.ParsedString;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import com.ssnagin.lab5java.sem2.lab5.files.FileManager;
import com.ssnagin.lab5java.sem2.lab5.scripts.exceptions.ScriptRecursionException;
import com.ssnagin.lab5java.sem2.lab5.validation.ValidationManager;
import com.ssnagin.lab5java.sem2.lab5.validation.factories.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * 
 * @author developer
 */
@ToString
@EqualsAndHashCode
public class Core {

    @Getter
    private static Core instance = new Core();
    
    private CollectionManager collectionManager;
    //private ValidationManager validationManager;
    private CommandManager commandManager;
    private Set<String> activeScripts;
    private InputParser inputParser;

    private FileManager fileManager;

    private Scanner scanner;

    private Stack<Scanner> inputScanners;
    private Scanner defaultScanner;
    
    @Getter
    ApplicationStatus applicationStatus;

    public static final String ASCII_LOGO = " ▗▄▄▖ ▄▄▄  █ █ ▗▞▀▚▖▗▞▀▘   ■  ▄  ▄▄▄  ▄▄▄▄  ▗▖  ▗▖▗▞▀▜▌▄▄▄▄  ▗▞▀▜▌     ▗▞▀▚▖ ▄▄▄ \n" +
                                            "▐▌   █   █ █ █ ▐▛▀▀▘▝▚▄▖▗▄▟▙▄▖▄ █   █ █   █ ▐▛▚▞▜▌▝▚▄▟▌█   █ ▝▚▄▟▌     ▐▛▀▀▘█    \n" +
                                            "▐▌   ▀▄▄▄▀ █ █ ▝▚▄▄▖      ▐▌  █ ▀▄▄▄▀ █   █ ▐▌  ▐▌     █   █           ▝▚▄▄▖█    \n" +
                                            "▝▚▄▄▖      █ █            ▐▌  █             ▐▌  ▐▌                 ▗▄▖           \n" +
                                            "                          ▐▌                                      ▐▌ ▐▌          \n" +
                                            "                                                                   ▝▀▜▌          \n" +
                                            "  ver. 1.0 | github.com/ssnagin/java-sem2-lab5.git                ▐▙▄▞▘        \n\n";
    
    public Core() {

        this.defaultScanner = new Scanner(System.in);

        inputScanners = new Stack<>();
        this.inputScanners.push(defaultScanner);

        // Singletone pattern
        this.collectionManager = CollectionManager.getInstance();
        this.commandManager = CommandManager.getInstance();

        this.inputParser = new InputParser();
        this.scanner = new Scanner(System.in);

        this.fileManager = FileManager.getInstance();

        activeScripts = new HashSet<>();

        registerCommands();

        this.setApplicationStatus(ApplicationStatus.RUNNING);
    }
    
    private void registerCommands() {
        this.commandManager.register(new CommandExit("exit", "exit this useless piece of masterpiece"));
        this.commandManager.register(new CommandHelp("help", "display help on available commands", commandManager));
        this.commandManager.register(new CommandExecuteScript("execute_script", "some description here", commandManager, collectionManager));
        this.commandManager.register(new CommandAdd("add", "add an object to collection", collectionManager, scanner));
        this.commandManager.register(new CommandShow("show", "show collection's elements", collectionManager));
        this.commandManager.register(new CommandClear("clear", "clear collection elements", collectionManager));
        this.commandManager.register(new CommandUpdate("update", "update <id> | update values of selected collection by id", collectionManager, scanner, commandManager));
        this.commandManager.register(new CommandRemoveById("remove_by_id", "remove_by_id <id> | removes an element with selected id", collectionManager));
        this.commandManager.register(new CommandAddIfMin("add_if_min", "adds an element into collection if it is the lowest element in it", collectionManager, commandManager, scanner));
        this.commandManager.register(new CommandHistory("history", "shows last 9 executed commands", commandManager));
        this.commandManager.register(new CommandPrintDescending("print_descending", "show collection's elements in reversed order", collectionManager));
        this.commandManager.register(new CommandCountByNumberOfParticipants("count_by_number_of_participants", "count_by_number_of_participants <numberOfParticipants>| shows the amount of fields with the same amount of participants", collectionManager));
        this.commandManager.register(new CommandRemoveLower("remove_lower", "removes elements that are lower than given", collectionManager, scanner));
        this.commandManager.register(new CommandGroupCountingByCreationDate("group_counting_by_creation_date", "groups collection elements by creation date", collectionManager));
        this.commandManager.register(new CommandSave("save", "save <filename> | saves collection to selected file. Creates if does not exist.", collectionManager, fileManager));
        this.commandManager.register(new CommandRandom("random", "random <amount> | adds to collection <amount> random elements", collectionManager));
    }

    public Scanner getCurrentScanner() {
        return inputScanners.peek();
    }

    public void pushFileScanner(File file) throws IOException, ScriptRecursionException {
        String canonicalPath = file.getCanonicalPath();
        if (activeScripts.contains(canonicalPath)) {
            throw new ScriptRecursionException("Recursion Detected!");
        }
        activeScripts.add(canonicalPath);
        inputScanners.push(new Scanner(file));
    }

    public void popScanner(File file) throws IOException {
        if (inputScanners.size() > 1) {
            Scanner scn = inputScanners.pop();
            activeScripts.remove(file.getCanonicalPath());
            scn.close();
        }
    }

    public void removeScanners() {
        while (inputScanners.size() > 1) {
            Scanner scn = inputScanners.pop();
            scn.close();
        }
    }

    public void clearActiveScripts() {
        this.activeScripts.clear();
    }

    public void start(String[] args) {
        
        // Step-by-step description of the algorithm.

        // 0. First, print logo

        this.printLogo();

        // 0.5 Register SIGINT:

        Signal.handle(new Signal("INT"), new SignalHandler() {  // Ctrl+C
            @Override
            public void handle(Signal sig) {
                onExit();
            }
        });

        // 1. Load file if given here:

        if (args.length > 0) {
            String path = String.join("", args);
            try {
                TreeSet<MusicBand> elements = fileManager.readCollection(path);
                this.collectionManager.setCollection(elements);
            } catch (Exception e) {
                Console.error("Error while reading file, skip adding into collection");
            }
        }

        // 2. Wait for the user input.
        // After it, parse given arguments with ArgumentParser

        ParsedString parsedString;

        while (true) {

            Console.print(Console.getShellArrow());

            // I need to replace this code for the future custom input (executeCommand from script) integration.

            String inputLine = getCurrentScanner().hasNextLine()
                    ? getCurrentScanner().nextLine()
                    : "";

            parsedString = InputParser.parse(inputLine, ParseMode.COMMAND_ONLY);

            // 2.1 If the string is null, skip the code:

            if (parsedString.isEmpty()) {
                // ... some code
                continue;
            }

            // 3 Executing commands according to user's input
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

    // === EVENTS ==== //
    
    public void onExit() {
        // Some code here, for example saving json.
        
        Console.separatePrint("Bye, have a great time!", this.getApplicationStatus().toString());
        System.exit(this.getApplicationStatus().getCode());
    }

}