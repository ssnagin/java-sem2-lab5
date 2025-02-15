/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DEVELOPER
 */
public class Coordinates {
    private long x; //Максимальное значение поля: 180
    private Integer y; //Максимальное значение поля: 750, Поле не может быть null
    
    public Coordinates(long x, Integer y) {
        setX(x);
        setY(y);
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setX(long x) {
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
}
