package com.company.lab8.compulsory;

import com.github.javafaker.Faker;

import java.sql.*;


public class AlbumController {
    private Connection connection = Database.getInstance().getConnection();

    public void create(String name, int artistId, int releaseYear) throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into albums (name, artist_id, release_year) values (?, ?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, artistId);
            preparedStatement.setInt(3, releaseYear);
            preparedStatement.executeUpdate();

        }
    }

    public Album findByArtist(int artistId) {
        Album album = null;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            statement = connection.prepareStatement("select name, artist_id, release_year from albums where artist_id =' " + artistId + "'");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                album = new Album(resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }


    public void print() throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("select * from albums");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnsNumber = resultSetMetaData.getColumnCount();

        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.print(resultSet.getString(i) + " | ");
            }
            System.out.println();
            System.out.println("-------------------------");
        }
    }

    public String generateName() {
        Faker faker = new Faker();
        return faker.book().title();

    }

    public int generateReleaseYear() {
        Faker faker = new Faker();
        return faker.number().numberBetween(1900, 2020);
    }

    public int generateListeners(){
        Faker faker = new Faker();
        return faker.number().numberBetween(1,10000);
    }

}

