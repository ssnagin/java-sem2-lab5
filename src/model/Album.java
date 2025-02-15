/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DEVELOPER
 */
public class Album {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long tracks = null; //Поле может быть null, Значение поля должно быть больше 0
    
    public Album(String name, Long tracks) {
        setName(name);
        setTracks(tracks);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setTracks(Long tracks) {
        this.tracks = tracks;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Long getTracks() {
        return this.tracks;
    }
    
    @Override
    public String toString() {
        return "Album={name='" + getName() + "', tracks='" + Long.toString(getTracks()) + "'}";
    }
}
