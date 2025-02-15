/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import model.interfaces.Validatable;

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
) implements Validatable {
    
    public MusicBand() {
        
    }
    
    // ==== Validatable interface overrides ==== //
    
    @Override
    public boolean isValid() {
//        return isXValid() && isYValid();
return false;
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
//        
//        if (isXValid()) {
//            results.append("x cannot be higher than 180");
//        }
//        if (isYValid()) {
//            results.append("y cannot be higher than 750 or null");
//        }
//        
        return results.toString();
    }

}
