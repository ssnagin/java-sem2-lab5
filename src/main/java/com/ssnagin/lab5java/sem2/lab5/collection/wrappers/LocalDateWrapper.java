/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.collection.wrappers;

import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Needs to make CreationDate if needed
 * @author developer
 */

@EqualsAndHashCode(callSuper=true)
@ToString
public class LocalDateWrapper extends MusicBand  {
    protected LocalDate localDate;
    
    protected MusicBand base;
    
    public LocalDateWrapper(MusicBand base) {
        this(base, LocalDate.now());
        this.base = base;
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
        this.base = base;
        
        setLocalDate(localDate);
    }
    
    public LocalDate getLocalDate() {
        return this.localDate;
    }
    
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    
    public int compareTo(LocalDateWrapper other) {
                
        if (other instanceof LocalDateWrapper) {
            LocalDateWrapper otherWrapper = (LocalDateWrapper) other;
            return this.base.compareTo(otherWrapper.base);
        }
        return this.base.compareTo(other);
    }
}
