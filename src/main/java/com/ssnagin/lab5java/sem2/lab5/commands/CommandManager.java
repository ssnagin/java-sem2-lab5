/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.commands;

import com.ssnagin.lab5java.sem2.lab5.commands.interfaces.Manageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author developer
 */
@EqualsAndHashCode
@ToString
public class CommandManager implements Manageable<Command> {
    
    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void register(Command command) {
        commands.put(command.getName(), command);
    }

    @Override
    public Command get(String commandName) {
        return commands.get(commandName);
    }
    
    public List<Command> getCommands() {  
        return new ArrayList<Command>(this.commands.values());
    }
}
