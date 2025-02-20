/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.model;

import com.ssnagin.lab5java.sem2.lab5.validation.annotations.NotEmpty;
import com.ssnagin.lab5java.sem2.lab5.validation.annotations.NotNull;
import com.ssnagin.lab5java.sem2.lab5.validation.annotations.PositiveNumber;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Class for describing Music Bands
 * @author DEVELOPER
 */
public class MusicBand implements Comparable<MusicBand> {
    @NotNull
    private long id; // Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    
    @NotNull
    @NotEmpty
    private String name; // Поле не может быть null, Строка не может быть пустой
    
    @NotNull
    private Coordinates coordinates; // Поле не может быть null
    
    @NotNull
    private LocalDate creationDate; // Поле не может быть null, Значение этого поля должно генерироваться автоматически
    
    @NotNull
    @PositiveNumber
    private Long numberOfParticipants; // Поле не может быть null, Значение поля должно быть больше 0
    
    @PositiveNumber
    private Integer singlesCount; // Поле может быть null, Значение поля должно быть больше 0
    
    private MusicGenre genre = null; // Поле может быть null
    
    @NotNull
    private Album bestAlbum; // Поле не может быть null

    public MusicBand(long id, String name, Coordinates coordinates, LocalDate creationDate, Long numberOfParticipants, Integer singlesCount, MusicGenre genre, Album bestAlbum) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.singlesCount = singlesCount;
        this.genre = genre;
        this.bestAlbum = bestAlbum;
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

    public LocalDate getCreationDate() {
        return creationDate;
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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MusicBand)) return false;
        MusicBand musicBand = (MusicBand) object;
        return id == musicBand.id &&
                name.equals(musicBand.name) &&
                coordinates.equals(musicBand.coordinates) &&
                creationDate.equals(musicBand.creationDate) &&
                numberOfParticipants.equals(musicBand.numberOfParticipants) &&
                Objects.equals(singlesCount, musicBand.singlesCount) &&
                genre == musicBand.genre &&
                bestAlbum.equals(musicBand.bestAlbum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, numberOfParticipants, singlesCount, genre, bestAlbum);
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", numberOfParticipants=" + numberOfParticipants +
                ", singlesCount=" + singlesCount +
                ", genre=" + genre +
                ", bestAlbum=" + bestAlbum +
                '}';
    }
    
    @Override
    public int compareTo(MusicBand otherMusicBand) {
        int result = this.name.compareTo(otherMusicBand.name);
        
        if (result == 0) this.creationDate.compareTo(otherMusicBand.getCreationDate());
        
        if (result == 0) this.coordinates.compareTo(otherMusicBand.getCoordinates());
        
        return result;
    }
}