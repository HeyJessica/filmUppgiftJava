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

    public boolean updateSerie(Serie oldSerie, Serie uppdatedSerie) {
        int foundPosition = findSerie(oldSerie);
        if(foundPosition <0) {
            System.out.println(oldSerie.getName() +", gick inte att hitta.");
            return false;
        }

        this.mySeries.set(foundPosition, uppdatedSerie);
        System.out.println(oldSerie.getName() + ", har uppdaterats med " + uppdatedSerie.getName());
        return true;
    }

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
            String favorit = "";
            if(this.mySeries.get(i).getFavorite()){
               favorit= "*Serien är en favorit!*";
            }
            System.out.println((i+1) + ". Namn -> " +
                    this.mySeries.get(i).getName() + ". Årtal -> " +
                    this.mySeries.get(i).getYear() + ". Säsonger -> " +
                    this.mySeries.get(i).getEpisodes() + ". Episoder -> " +
                    this.mySeries.get(i).getSeasons() +". "+ favorit);

        }

    }


}
