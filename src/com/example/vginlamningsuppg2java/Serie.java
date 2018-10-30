package com.example.vginlamningsuppg2java;

public class Serie extends Film{


    //privata instansvariabler för subklassen
    private String episodes;
    private String seasons;

    //konstruktor för subklassen
    public Serie(String name, String year, boolean isFavorite, String episodes, String seasons){
        super(name, year, isFavorite);
        this.episodes = episodes;
        this.seasons = seasons;
    }

    public String getEpisodes() { return episodes; }
    public String getSeasons() { return seasons; }
}
