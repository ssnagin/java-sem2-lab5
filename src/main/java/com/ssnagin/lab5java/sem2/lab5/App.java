/*
 * This source file was generated by the Gradle 'init' task
 */
package com.ssnagin.lab5java.sem2.lab5;

import com.ssnagin.lab5java.sem2.lab5.collection.CollectionManager;
import com.ssnagin.lab5java.sem2.lab5.collection.model.Album;
import com.ssnagin.lab5java.sem2.lab5.collection.model.Coordinates;
import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicGenre;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Entry script for running Application
 * @author developer
 */
@EqualsAndHashCode
@ToString
public class App {
    public static void main(String[] args) {
        
        /*
        
        Code for the future
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().toString());
        }
        */
        
        Core core = new Core();
        core.start();
    }
    
    public static void run() {
        /*
        Пример создания коллекции
        
        MusicBand musicBand = new MusicBand(
            1,
            "test", 
            new Coordinates((long) 28, 1),
            LocalDate.now(),
            1L, 
            1,
            MusicGenre.MATH_ROCK,
            new Album("Test", (long) 123)
        );
        
        */
        
        CollectionManager collectionManager = new CollectionManager();
        Validate validationController = new Validate();
        
        collectionManager.addElement(new MusicBand(
            "test", 
            new Coordinates((long) 28, 1),
            1L, 
            1,
            MusicGenre.MATH_ROCK,
            new Album("Test", (long) 123)
        ));
        
        
    }
}
