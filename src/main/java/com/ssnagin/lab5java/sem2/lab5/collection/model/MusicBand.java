/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.collection.model;

import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.description.annotations.Description;
import com.ssnagin.lab5java.sem2.lab5.validation.annotations.NotEmpty;
import com.ssnagin.lab5java.sem2.lab5.validation.annotations.NotNull;
import com.ssnagin.lab5java.sem2.lab5.validation.annotations.PositiveNumber;
import java.time.LocalDate;
import java.util.UUID;
import lombok.EqualsAndHashCode;

/**
 * Class for describing Music Bands
 * @author DEVELOPER
 */
@EqualsAndHashCode(callSuper=true)
public class MusicBand extends Entity<MusicBand> {
    
    @NotNull 
    @PositiveNumber
    protected long id = -1; // Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    
    @NotNull
    @NotEmpty
    @Description(
            name="имя", 
            description="Название музыкальной группы"
    )
    protected String name; // Поле не может быть null, Строка не может быть пустой
    
    @NotNull
    @Description(
        name="координаты", 
        description="Какие-то координаты музыкальной группы"
    )
    protected Coordinates coordinates; // Поле не может быть null
    
    @NotNull
    @PositiveNumber
    @Description(
        name="количество участников", 
        description="количество участников данной группы"
    )
    protected Long numberOfParticipants; // Поле не может быть null, Значение поля должно быть больше 0
    
    @PositiveNumber
    @Description(
        name="количество синглов", 
        description="сколько синглов выпустила данная группа"
    )
    protected Integer singlesCount; // Поле может быть null, Значение поля должно быть больше 0
    
    @Description(
        name="жанр музыки", 
        description="жанр музыки"
    )
    protected MusicGenre genre = null; // Поле может быть null
    
    @NotNull
    @Description(
        name="лучший альбом", 
        description="какой-то лучший альбом"
    )
    protected Album bestAlbum; // Поле не может быть null

    /**
     * Constructor with specified id
     * 
     * @param id
     * @param name
     * @param coordinates
     * @param creationDate
     * @param numberOfParticipants
     * @param singlesCount
     * @param genre
     * @param bestAlbum 
     */
    public MusicBand(long id, String name, Coordinates coordinates, Long numberOfParticipants, Integer singlesCount, MusicGenre genre, Album bestAlbum) {
        this.setId(id);
        this.setName(name);
        this.setCoordinates(coordinates);
        this.setNumberOfParticipants(numberOfParticipants);
        this.setSinglesCount(singlesCount);
        this.setGenre(genre);
        this.setBestAlbum(bestAlbum);
    }
    
    /**
     * Constructor without specified id, it will be safely generated
     * 
     * @param name
     * @param coordinates
     * @param creationDate
     * @param numberOfParticipants
     * @param singlesCount
     * @param genre
     * @param bestAlbum 
     */
    public MusicBand(String name, Coordinates coordinates, Long numberOfParticipants, Integer singlesCount, MusicGenre genre, Album bestAlbum) {
        
        this(
                MusicBand.generateId(),
                name,
                coordinates,
                numberOfParticipants,
                singlesCount,
                genre,
                bestAlbum
        );
    }
    
    /**
     * Constructor for prepared statements
     */
    public MusicBand() {
        this(
                null,
                null,
                null,
                null,
                null,
                null
                );
    }

   
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public Integer getSinglesCount() {
        return singlesCount;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public Album getBestAlbum() {
        return bestAlbum;
    }
    
    private static long generateId() {
        long result = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        if (result == 0) result = MusicBand.generateId();
        return result;
    }
    
    private void setId(long id) {
        if (this.id <= -1) this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setNumberOfParticipants(Long numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setSinglesCount(Integer singlesCount) {
        this.singlesCount = singlesCount;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public void setBestAlbum(Album bestAlbum) {
        this.bestAlbum = bestAlbum;
    }

    @Override
    public String toString() {
        return "MusicBand={" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", numberOfParticipants=" + numberOfParticipants +
                ", singlesCount=" + singlesCount +
                ", genre=" + genre +
                ", bestAlbum=" + bestAlbum +
                '}';
    }
    
    @Override
    public int compareTo(MusicBand otherMusicBand) {
        
        int result = this.getName().compareTo(otherMusicBand.getName());
        
        if (result == 0) this.getSinglesCount().compareTo(otherMusicBand.getSinglesCount());
        
        if (result == 0) this.getCoordinates().compareTo(otherMusicBand.getCoordinates());
        
        return result;
    }
}