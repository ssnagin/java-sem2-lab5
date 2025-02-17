/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.model;

import com.ssnagin.lab5java.sem2.lab5.validation.annotations.MaxValue;
import java.util.Objects;

/**
 *
 * @author DEVELOPER
 */
public class Coordinates {
    @MaxValue(maxValue=180)
    private Long x = null; //Максимальное значение поля: 180. (Так как long может быть null, ставим Long вместо long)
    
    @MaxValue(maxValue=750)
    private Integer y; //Максимальное значение поля: 750, Поле не может быть null

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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    // ==== Validatable interface overrides ==== //
    
//    @Override
//    public boolean isValid() {
//        return isXValid() && isYValid();
//    }
//    
//    @Override
//    public String parseValidationError() {
//       /** 
//        * StringBuidler instead of String:
//        * pros:
//        * works with a single instance (object), which can be modified via
//        * append(), delete(), insert(), replace(), reverse()
//        */ 
//        StringBuilder results = new StringBuilder();
//        results.append("");
//        
//        if (isXValid()) {
//            results.append("x cannot be higher than 180");
//        }
//        if (isYValid()) {
//            results.append("y cannot be higher than 750 or null");
//        }
//        
//        return results.toString();
//    }
//
//    private boolean isXValid() {
//        return (this.x > X_MAX) ? false : true;
//    }
//
//    private boolean isYValid() {
//        return (this.y == null || this.y > Y_MAX) ? false : true;
//    }
}
