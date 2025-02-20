/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5;

/**
 * 
 * @author developer
 */
public class PrettyPrint {
    
    
    public static void log(Object text) {
        PrettyPrint.log(text.toString(), "       ");
    }

    public static void log(Object text, String leftSide) {

        if (leftSide.length() > 7) {
            leftSide = leftSide.substring(0, 7);
        } else {
            for (int i = 0; i < 7 - leftSide.length(); i++) {
                leftSide += " ";
            }
        }

        String prepared = leftSide + "| " + text.toString();
        PrettyPrint.print(prepared);
    }

    public static void print(Object text) {
        System.out.println(text.toString());
    }
}
