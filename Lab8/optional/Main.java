package com.company.lab8.compulsory;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        DatabaseController database = new DatabaseController();

        ChartController chartController = new ChartController();
        AlbumController albumController = new AlbumController();
        ArtistController artistController = new ArtistController();

        database.createTables();
        chartController.createTable();


        try {
//            artistController.create("Artist1", "Romania");
//            artistController.create("Artist2", "Bulgaria");

            //afisare artists
            //System.out.println("\n==========Artists==========");
            //System.out.println("-------------------------");
            //artistController.print();

//            albumController.create("Album1", artistController.findArtistIdByName("Artist1"), 2015);
//            albumController.create("Album2", artistController.findArtistIdByName("Artist2"), 2020);

            //generez si adaug 10 albume cu cate 1 artist

            /*for (int i = 0; i <= 10; i++) {
                String artistName = artistController.generateName();
                String albumName = albumController.generateName();
                int albumReleaseYear = albumController.generateReleaseYear();
                int listeners = albumController.generateListeners();
                System.out.println(artistName + " " + albumName + " " + albumReleaseYear);
                artistController.create(artistName, artistController.generateCountry());
                albumController.create(albumName, artistController.findArtistIdByName(artistName), albumReleaseYear);
                chartController.create(albumName, listeners, albumReleaseYear);
            }*/

            //incrementez numarul de ascultatori al unui album
            chartController.listenAlbum("As I Lay Dying");

            //afisare albums
            //System.out.println("\n=========Albums==========");
            //System.out.println("-------------------------");
            //albumController.print();


            //afisez ranking-ul(chart-ul ordonat dupa ascultatori descrescator)
            System.out.println("\n=========Chart==========");
            System.out.println("-------------------------");
            chartController.print();
            chartController.report();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        database.closeConnection();

    }
}