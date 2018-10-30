package com.example.vginlamningsuppg2java;

import java.util.ArrayList;

public class Filmer {

    private ArrayList<Film> myFilms;

    //konstruktor
    public Filmer(){

        this.myFilms = new ArrayList<Film>();
    }

    public boolean addNewFilm(Film newFilm) {
        if(findFilm(newFilm.getName()) >=0) {
            System.out.println("Filmen är redan sparad.");
            return false;
        }

        myFilms.add(newFilm);
        return true;

    }

    public boolean updateFilm(Film oldFilm, Film uppdatedFilm) {
        int foundPosition = findFilm(oldFilm);
        if(foundPosition <0) {
            System.out.println(oldFilm.getName() +", gick inte att hitta.");
            return false;
        }

        this.myFilms.set(foundPosition, uppdatedFilm);
        return true;
    }

    public boolean removeFilm(Film film) {
        int foundPosition = findFilm(film);
        if(foundPosition <0) {
            System.out.println(film.getName() +", gick inte att hitta.");
            return false;
        }
        this.myFilms.remove(foundPosition);
        System.out.println(film.getName() + ", har tagits bort.");
        return true;
    }

    private int findFilm(Film film) {
        return this.myFilms.indexOf(film);
    }

    private int findFilm(String filmName) {
        for(int i=0; i<this.myFilms.size(); i++) {
            Film film = this.myFilms.get(i);
            if(film.getName().equals(filmName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryFilm(Film film) {
        if(findFilm(film) >=0) {
            return film.getName();
        }
        return null;
    }

    public Film queryFilm(String name) { //returnerar Film (ett objekt)
        int position = findFilm(name);
        if(position >=0) {
            return this.myFilms.get(position);
        }

        return null;
    }

    public void printFilms() {
        System.out.println("Filmlista:");
        for(int i=0; i<this.myFilms.size(); i++) {
            String favorit = "";
            if(this.myFilms.get(i).getFavorite()){
                favorit = "*Filmen är en favorit!*";
            }
            System.out.println((i+1) + ". Namn -> " +
                    this.myFilms.get(i).getName() + ". Årtal -> " +
                    this.myFilms.get(i).getYear() + ". "+
                    favorit);
        }

    }
}
