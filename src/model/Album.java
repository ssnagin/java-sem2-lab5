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
public class Album implements Validatable {
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
    
    // ==== Validatable interface overrides ==== //
    
    @Override
    public boolean isValid() {
        return isNameValid() && isTracksValid();
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
        
        if (isNameValid()) {
            results.append("name cannot be null");
        }
        if (isTracksValid()) {
            results.append("tracks can be only positive");
        }
        
        
        return results.toString();
    }

    private boolean isNameValid() {
        return (this.name == null || this.name.equals("")) ? false : true;
    }

    private boolean isTracksValid() {
        return tracks <= 0 ? false : true;
    }
}
