/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.collection;

import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import java.util.TreeSet;

/**
 * 
 * @author developer
 */
public class CollectionManager {
    
    private TreeSet<MusicBand> collection = new TreeSet();
    
    public void addElement(MusicBand element) {
        this.collection.add(element);
    }
    
    public MusicBand getElementById(long otherId) {
        MusicBand result = null;
        
        for (MusicBand row : this.collection) {
            if (((Long) row.getId()).equals(otherId)) {
                result = row;
                break;
            }
        }
        
        return result;
    }
    
    public void removeElementById(int otherId) {
        MusicBand result = this.getElementById(otherId);
        if (result != null) this.removeElement(result);
    }
    
    public void removeElement(MusicBand musicBand) {
        this.collection.remove(musicBand);
    }
    
    public void removeAllElements() {
        for (MusicBand element : this.collection) {
            this.removeElement(element);
        }
    }
    
    public MusicBand getLastElement() {
        return this.collection.last();
    }
    
    public MusicBand getFirstElement() {
        return this.collection.first();
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        if (this.collection.isEmpty()) {
            result.append("My stomache is as empty as this Collection...");
            return result.toString();
        }
        
        result.append("CollectionManager={\n");
        
        for (MusicBand musicBand : this.collection) {
            result.append(musicBand.toString()).append("\n");
        }
        
        result.append("}\n");
        
        return result.toString();
    }
}
