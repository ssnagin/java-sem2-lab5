/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.inputParser;

import com.ssnagin.lab5java.sem2.lab5.console.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Module that is responsible for parsing user's input
 * 
 * @author developer
 */
public class InputParser {
    
    private static final String REGEX_EXPRESSION = "(?:[/-]+(?<gr1>\\S+?))|(?:\\\"+(?<gr2>.+?)\\\")|(?:'[/-]+(?<gr3>.+?)')|(?:\\\"(?<gr4>.+?)\\\")|(?:'(?<gr5>.+?)')|(?<gr6>\\S+)";
    
    public static ParsedString parse(Object text) {
        
        ParsedString result;
        
        if (text == null) return null;
        
        // Setting up our pattern searcher
        
        final Pattern pattern = Pattern.compile(InputParser.REGEX_EXPRESSION, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(text.toString());
        
        result = new ParsedString();
        
        try {
            while (matcher.find()) {
//            System.out.println("Full match: " + matcher.group(0));
            
                for (int i = 1; i <= matcher.groupCount(); i++) {

                    if (matcher == null) continue;

                    result.addFromStream(matcher.group(i));

    //                System.out.println("Group " + i + ": " + matcher.group(i));
                }
        }
        } catch(Exception exception) {
            Console.error(exception.toString());
        }
        return result;
    }
}
