/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import exceptions.BeyondLimitsException;

/**
 *
 * @author DEVELOPER
 */
public class Coordinates {
    private long x; //Максимальное значение поля: 180
    private Integer y; //Максимальное значение поля: 750, Поле не может быть null
    
//    private void setX(long x) {
//        try {
//            this.x = x;
//        } catch (BeyondLimitsException exception) {
//            throw new BeyondLimitsException();
//        }
//        
//    }
    
    private void setY(int y) {
        this.y = y;
    }
    
    public boolean validate() {
        
    }
}
