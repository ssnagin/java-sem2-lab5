/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.collection.wrappers;

import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Needs to make CreationDate if needed
 * @author developer
 */

@EqualsAndHashCode(callSuper=true)
@ToString
@Getter
@Setter
public class LocalDateWrapper extends MusicBand  {
    protected LocalDate localDate;
    
    public LocalDateWrapper(MusicBand base) {
        this(base, LocalDate.now());
    }
    
    public LocalDateWrapper(MusicBand base, LocalDate localDate) {
        super(
                base.getId(),
                base.getName(),
                base.getCoordinates(),
                base.getNumberOfParticipants(),
                base.getSinglesCount(),
                base.getGenre(),
                base.getBestAlbum()
        );
        
        setLocalDate(localDate);
    }
}
