package com.company.lab8.compulsory;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.Collections;

public class AlbumController {

    public void create(String name, int artistId, int releaseYear) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into albums (name, artist_id, release_year) values (?, ?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, artistId);
            preparedStatement.setInt(3, releaseYear);
            preparedStatement.executeUpdate();
        }
    }

    public void findByArtist(int artistId) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select name from albums where id = " + artistId)) {
            System.out.println(resultSet.next() ? Integer.valueOf(resultSet.getString(1)) : null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer findArtist(String albumName) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select artist_id from albums where name =' " + albumName + "'")) {
            return resultSet.next() ? resultSet.getInt(1) : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void print() throws SQLException {
        Connection connection = Database.getConnection();
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

}

