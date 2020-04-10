package com.company.lab8.compulsory;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        DatabaseController database = new DatabaseController();

        AlbumController albums = new AlbumController();
        ArtistController artists = new ArtistController();

        database.createTables();

        Artist artist2 = new Artist("Artist2","Bulgaria");

        try {
            artists.create("Artist1", "Romania");
            System.out.println("\n==========Artists==========");
            System.out.println("-------------------------");
            artists.print();
            albums.create("Album1", artists.findByName("Artist1"), 2015);
            System.out.println("\n=========Albums==========");
            System.out.println("-------------------------");
            albums.print();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        database.closeConnection();

    }
}