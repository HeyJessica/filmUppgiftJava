package com.example.vginlamningsuppg2java;

import java.util.ArrayList;

public class Serier {
    private ArrayList<Serie> mySeries;

    public Serier() {
        this.mySeries = new ArrayList<Serie>();
    }

    public boolean addNewSerie(Serie newSerie) {
        if(findSerie(newSerie.getName()) >=0) {
            System.out.println("Serien är redan sparad.");
            return false;
        }

        mySeries.add(newSerie);
        return true;

    }

  /*  public boolean updateFilm(Film oldFilm, Film uppdatedFilm) {
        int foundPosition = findFilm(oldFilm);
        if(foundPosition <0) {
            System.out.println(oldFilm.getName() +", gick inte att hitta.");
            return false;
        }

        this.myFilms.set(foundPosition, uppdatedFilm);
        System.out.println(oldFilm.getName() + ", har uppdaterats med " + uppdatedFilm.getName());
        return true;
    }*/

    public boolean removeSerie(Serie serie) {
        int foundPosition = findSerie(serie);
        if(foundPosition <0) {
            System.out.println(serie.getName() +", gick inte att hitta.");
            return false;
        }
        this.mySeries.remove(foundPosition);
        System.out.println(serie.getName() + ", har tagits bort.");
        return true;
    }

    private int findSerie(Serie serie) {
        return this.mySeries.indexOf(serie);
    }

    private int findSerie(String serieName) {
        for(int i=0; i<this.mySeries.size(); i++) {
            Serie serie = this.mySeries.get(i);
            if(serie.getName().equals(serieName)) {
                return i;
            }
        }
        return -1;
    }

    public String querySerie(Serie serie) {
        if(findSerie(serie) >=0) {
            return serie.getName();
        }
        return null;
    }

    public Serie querySerie(String name) { // ( returnerar Serie (ett objekt))
        int position = findSerie(name);
        if(position >=0) {
            return this.mySeries.get(position);
        }

        return null;
    }

    public void printSeries() {
        System.out.println("Serielista:");
        for(int i=0; i<this.mySeries.size(); i++) {
            System.out.println((i+1) + "." +
                    this.mySeries.get(i).getName() + " -> " +
                    this.mySeries.get(i).getYear());

        }

    }


}
