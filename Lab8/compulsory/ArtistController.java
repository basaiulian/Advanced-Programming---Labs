package com.company.lab8.compulsory;

import java.sql.*;

public class ArtistController {

    public void create(String name, String country) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into artists (name, country) values (?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2,country);
            preparedStatement.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select id from artists where name like '" + name + "'")) {
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

}
