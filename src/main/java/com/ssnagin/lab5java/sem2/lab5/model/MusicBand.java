/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.model;

import java.time.LocalDate;

/**
 * Class for describing Music Bands
 * @author DEVELOPER
 */
public record MusicBand(
    long id, //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    String name, //Поле не может быть null, Строка не может быть пустой
    Coordinates coordinates, //Поле не может быть null
    LocalDate creationDate, //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    Long numberOfParticipants, //Поле не может быть null, Значение поля должно быть больше 0
    Integer singlesCount, //Поле может быть null, Значение поля должно быть больше 0
    MusicGenre genre, //Поле может быть null
    Album bestAlbum //Поле не может быть null
)  {
    
    
}
