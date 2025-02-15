/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.interfaces.Validatable;

/**
 *
 * @author DEVELOPER
 */
public class Coordinates implements Validatable {
    private Long x = null; //Максимальное значение поля: 180. (Так как long может быть null, ставим Long вместо long)
    private Integer y; //Максимальное значение поля: 750, Поле не может быть null
    
    private final long X_MAX = 180;
    private final Integer Y_MAX = 750;
    
    public Coordinates(Long x, Integer y) {
        setX(x);
        setY(y);
    }
    
    public Coordinates(Integer y) {
        this(null, y);
    }
    
    public void setY(Integer y) {
        this.y = y;
    }
    
    public void setX(Long x) {
        this.x = x;
    }
    
    public long getX() {
        return this.x;
    }
    
    public Integer getY() {
        return this.y;
    }
    
    @Override
    public String toString() {
        return "Coordinates={x=" + Long.toString(x) + ", y=" + Integer.toString(y) + "}";
    }
    
    // ==== Validatable interface overrides ==== //
    
    @Override
    public boolean isValid() {
        return isXValid() && isYValid();
    }
    
    @Override
    public String parseValidationError() {
       /** 
        * StringBuidler instead of String:
        * pros:
        * works with a single instance (object), which can be modified via
        * append(), delete(), insert(), replace(), reverse()
        */ 
        StringBuilder results = new StringBuilder();
        results.append("");
        
        if (isXValid()) {
            results.append("x cannot be higher than 180");
        }
        if (isYValid()) {
            results.append("y cannot be higher than 750 or null");
        }
        
        return results.toString();
    }

    private boolean isXValid() {
        return (this.x > X_MAX) ? false : true;
    }

    private boolean isYValid() {
        return (this.y == null || this.y > Y_MAX) ? false : true;
    }
}
