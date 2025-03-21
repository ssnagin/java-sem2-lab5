/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.collection.model;

import com.ssnagin.lab5java.sem2.lab5.description.annotations.Description;
import com.ssnagin.lab5java.sem2.lab5.validation.annotations.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DEVELOPER
 */
@EqualsAndHashCode(callSuper=true)
@Getter
@Setter
public class Album extends Entity<Album> {
    @NotNull
    @Description(
        name="имя", 
        description="какое-то описание"
    )
    private String name; //Поле не может быть null, Строка не может быть пустой
    
    @Description(
        name="количество треков", 
        description="какое-то описание"
    )
    private Long tracks = null; //Поле может быть null, Значение поля должно быть больше 0
    
    public Album(String name, Long tracks) {
        setName(name);
        setTracks(tracks);
    }
    
    public Album() {
        this(null, null);
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
