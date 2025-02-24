/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.collection.model;

import lombok.EqualsAndHashCode;

/**
 *
 * @author DEVELOPER
 */
@EqualsAndHashCode
public class Album implements Comparable<Album> {
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
    
    @Override
    public int compareTo(Album otherAlbum) {
        int result = this.name.compareTo(otherAlbum.name);
        
        if (result == 0) result = this.tracks.compareTo(otherAlbum.tracks);
        
        return result;
    }
}
