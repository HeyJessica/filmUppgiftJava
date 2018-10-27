package com.example.vginlamningsuppg2java;

public class Film {
    private String name;
    private String year;
    private boolean isFavorite;

    //konstruktor
    public Film(String name, String year){
        this.name = name;
        this.year = year;
        this.isFavorite = false;
    }

    public String getName(){ return name; }
    public String getYear(){ return year; }
    public boolean getFavorite(){ return isFavorite; }

   /* public static Film createFilm(String name, String year, boolean isFavorite){
        return new Film(name, year, isFavorite);

    }*/
}