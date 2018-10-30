package com.example.vginlamningsuppg2java;

public class Film {
    private String name;
    private String year;
    private boolean isFavorite;

    //konstruktor
    public Film(String name, String year, boolean isFavorite){
        this.name = name;
        this.year = year;
        this.isFavorite = isFavorite;
    }

    public String getName(){ return name; }
    public String getYear(){ return year; }
    public boolean getFavorite(){ return isFavorite; }
}
