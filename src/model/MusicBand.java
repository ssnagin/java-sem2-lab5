/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 * Class for describing Music Bands
 * @author DEVELOPER
 */
public class MusicBand  {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    private Integer singlesCount = null; //Поле может быть null, Значение поля должно быть больше 0
    private MusicGenre genre = null; //Поле может быть null
    private Album bestAlbum; //Поле не может быть null
    
    public MusicBand(
            String name, 
            Coordinates coordinates,
            LocalDate creationDate,
            Long numberOfParticipants,
            Integer singlesCount,
            MusicGenre genre,
            Album bestAlbum) {
            
    }
    
}
