/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssnagin.lab5java.sem2.lab5.files;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ssnagin.lab5java.sem2.lab5.collection.model.MusicBand;
import com.ssnagin.lab5java.sem2.lab5.collection.wrappers.LocalDateWrapper;
import com.ssnagin.lab5java.sem2.lab5.console.Console;
import com.ssnagin.lab5java.sem2.lab5.files.adapters.LocalDateAdapter;
import com.sun.source.tree.Tree;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author developer
 */
public class FileManager {

    @Getter
    private static FileManager instance = new FileManager();

    public Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();



    public void write(MusicBand musicBand, String path) {
        try (PrintWriter collectionPrintWriter = new PrintWriter(new File(path))) {
            collectionPrintWriter.println(gson.toJson(musicBand));
            Console.println("Collection was saved");
        } catch (IOException exception) {
            Console.error("Can't open executable file");
        }
    }

    public void write(TreeSet<MusicBand> musicBands, String path) {
        try (PrintWriter collectionPrintWriter = new PrintWriter(new File(path))) {
            collectionPrintWriter.println(gson.toJson(musicBands));
            Console.println("Collection was saved");
        } catch (IOException exception) {
            Console.error("Can't open executable file");
        }
    }

    public TreeSet<MusicBand> read(String path) throws FileNotFoundException, IOException {
        if (path == null) return null;
        if (path.isEmpty()) return null;

        String buffResult;

        FileInputStream fileInputStream = new FileInputStream(path);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        byte[] bytes = bufferedInputStream.readAllBytes();
        buffResult = new String(bytes, StandardCharsets.UTF_8);

        if (buffResult.isEmpty()) buffResult = "[]";

        return gson.fromJson(buffResult, new TypeToken<TreeSet<MusicBand>>() {}.getType());
    }
}
