package com.company.lab8.compulsory;

import com.github.javafaker.Faker;

import java.sql.*;

public class ArtistController {
    private Connection connection = Database.getInstance().getConnection();

    public void create(String name, String country) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into artists (name, country) values (?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, country);
            preparedStatement.executeUpdate();
        }
    }

    public Integer findArtistIdByName(String name) {
        Integer resultId = null;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            statement = connection.prepareStatement("select id from artists where name like '" + name + "'");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultId = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultId;
    }

    public Artist findByName(String name) {
        Artist artist = null;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            statement = connection.prepareStatement("select name, country from artists where name like '" + name + "'");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                artist = new Artist(resultSet.getString(1),
                        resultSet.getString(2)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artist;
    }

    public void print() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("select * from artists");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnsNumber = resultSetMetaData.getColumnCount();

        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.print(resultSet.getString(i) + " || ");
            }
            System.out.println();
            System.out.println("-------------------------");
        }
    }

    public String generateName() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public String generateCountry() {
        Faker faker = new Faker();
        return faker.country().name();
    }

}
