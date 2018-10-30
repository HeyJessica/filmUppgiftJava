package com.example.vginlamningsuppg2java;

import java.util.Scanner;

public class VgInlamningsuppg2Java {
    private static Scanner scan = new Scanner(System.in);
    private static Filmer filmer = new Filmer();
    private static Serier serier = new Serier();

    public static void main(String[] args) {

        boolean quit = false;
        System.out.println("För att visa meny för filmer tryck 1, för serier tryck 2");

        int option = scan.nextInt();
        scan.nextLine();
        if(option==1){
            printFilmActions();
        } else {
            printSerieActions();
        }
        // printActions();
        while (!quit) {
                System.out.println("\nVälj: (5 för att visa val)");

            int choise = scan.nextInt();
            scan.nextLine();

            switch (choise) {
                case 0:
                    System.out.println("\nStänger ner...");
                    quit = true;
                    break;

                case 1:
                    if(option==1){
                        filmer.printFilms();
                        break;}
                    else{
                        serier.printSeries();
                        break;}

                case 2:
                    if(option==1){
                        addNewFilm();
                        break;}
                    else{
                        addNewSerie();
                        break;
                    }

                case 3:
                    if(option==1){
                    updateFilm();
                    break;}
                    else{
                        updateSerie();
                        break;
                    }

                case 4:
                    if(option==1){
                        removeFilm();
                        break;}
                    else{
                        removeSerie();
                        break;
                    }

                case 5:
                    if(option==1){
                        printFilmActions();
                        break;}
                    else printSerieActions();
                    break;
            }
        }
    }

    private static void addNewFilm() {
        System.out.println("Skriv in namnet på din film: ");
        String name = scan.nextLine();
        System.out.println("Skriv in vilket år filmen kom: ");
        String year = scan.nextLine();
        Film newFilm = new Film(name, year, false); //skapar ett objekt. Boolean favorite är false när objektet skapas
        if (filmer.addNewFilm(newFilm)) {
            System.out.println("Ny film tillagd: Namn: " + name + ", Årtal: " + year);
        } else {
            System.out.println("Kan inte lägga till, " + name + " finns redan.");
        }
    }

    private static void addNewSerie() {
        System.out.println("Skriv in namnet på serien: ");
        String name = scan.nextLine();
        System.out.println("Skriv in vilket år serien kom: ");
        String year = scan.nextLine();
        System.out.println("Skriv in hur många episoder serien har: ");
        String episodes = scan.nextLine();
        System.out.println("Skriv in hur många säsonger serien har: ");
        String seasons = scan.nextLine();
        Serie newSerie= new Serie(name, year, false, episodes, seasons); //skapar ett nytt objekt och skickar in värden direkt till konstruktorn
        if (serier.addNewSerie(newSerie)) {
            System.out.println("Ny serie tillagd: Namn: " + name + ", årtal: " + year + ", antal säsonger: " + seasons + ", antal episoder: "+ episodes);
        } else {
            System.out.println("Kan inte lägga till, " + name + " finns redan.");
        }
    }

    private static void updateFilm() {
        System.out.println("Skriv in namnet på filmen som skall uppdateras: ");
        String name = scan.nextLine();
        Film existingFilm = filmer.queryFilm(name);
        if (existingFilm == null) {
            System.out.println("Kan inte hitta filmen.");
            return;
        }

        System.out.print("Skriv in nytt namn för filmen: ");
        String newName = scan.nextLine();
        System.out.print("Skriv in nytt årtal för filmen: ");
        String newYear = scan.nextLine();

       System.out.print("Vill du lägga till filmen som favorit? j/n: ");
       boolean favorite = false;
       String answer = scan.nextLine();
       if(answer.equals("j")){
           favorite = true;
        }

        Film newFilm = new Film(newName, newYear, favorite);
        if (filmer.updateFilm(existingFilm, newFilm)) {
            System.out.println("Filmen är uppdaterad!");
        } else {
            System.out.println("Gick inte att updatera.");
        }
    }

    private static void updateSerie() {
        System.out.println("Skriv in namnet på serien som skall uppdateras: ");
        String name = scan.nextLine();
        Serie existingSerie = serier.querySerie(name);
        if (existingSerie == null) {
            System.out.println("Kan inte hitta filmen.");
            return;
        }

        System.out.print("Skriv in nytt namn för serien: ");
        String newName = scan.nextLine();
        System.out.print("Skriv in nytt årtal för serien: ");
        String newYear = scan.nextLine();
        System.out.print("Skriv in antal säsonger: ");
        String newSeasons = scan.nextLine();
        System.out.print("Skriv in antal episoder: ");
        String newEpisodes = scan.nextLine();

        System.out.print("Vill du lägga till serien som favorit? j/n: ");
        boolean favorite = false;
        String answer = scan.nextLine();
        if(answer.equals("j")){
            favorite = true;
        }

        Serie newSerie = new Serie(newName, newYear, favorite, newSeasons, newEpisodes);
        if (serier.updateSerie(existingSerie, newSerie)) {
            System.out.println("Serien är uppdaterad!");
        } else {
            System.out.println("Gick inte att updatera.");
        }
    }


    private static void removeFilm() {
        System.out.println("Skriv in namnet på filmen som skall tas bort: ");
        String name = scan.nextLine();
        Film existingFilm = filmer.queryFilm(name);
        if (existingFilm == null) {
            System.out.println("Kan inte hitta filmen, gör ett nytt val");
            return;
        }

        if (filmer.removeFilm(existingFilm)) {
            System.out.println("Filmen har tagits bort!");
        } else {
            System.out.println("Kan inte ta bort filmen. Gör ett nytt val");
        }
    }

    private static void removeSerie() {
        System.out.println("Skriv in namnet på serien som ska tas bort: ");
        String name = scan.nextLine();
        Serie existingSerie = serier.querySerie(name);
        if (existingSerie == null) {
            System.out.println("Kan inte hitta serien");
            return;
        }

        if (serier.removeSerie(existingSerie)) {
            System.out.println("Serien har tagits bort!");
        } else {
            System.out.println("Kan inte ta bort serien, gör ett nytt val");
        }
    }

    private static void printFilmActions() {
        System.out.println("\nVälj:");
        System.out.println("0  - Stäng av\n" +
                "1  - Visa filmer\n" +
                "2  - Lägga till en ny film\n" +
                "3  - Uppdatera en inlagd film\n" +
                "4  - Ta bort en inlagd film\n" +
                "5  - Visa lista över alla val.");
    }

    private static void printSerieActions() {
        System.out.println("\nVälj:");
        System.out.println("0  - Stäng av\n" +
                "1  - Visa serier\n" +
                "2  - Lägga till en ny serie\n" +
                "3  - Uppdatera en inlagd serie\n" +
                "4  - Ta bort en inlagd serie\n" +
                "5  - Visa lista över alla val.");
    }
}
