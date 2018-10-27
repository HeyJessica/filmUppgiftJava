package com.example.vginlamningsuppg2java;

public class Serie extends Film{


    //privata instansvariabler för subklassen
    private String episodes;
    private String seasons;

    //konstruktor för subklassen
    public Serie(String name, String year, String favorite, String episodes, String seasons){
        super("", "", "");
        this.episodes = episodes;
        this.seasons = seasons;
    }

    public String getEpisodes() { return episodes; }
    public String getSeasons() { return seasons; }

    public static Serie createSerie(String name, String year, String favorite, String episodes, String seasons){
        return new Serie(name, year, favorite, episodes, seasons);
    }

}
