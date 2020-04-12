package com.company.lab8.compulsory;

import java.sql.*;

public class ChartController {
    private Connection connection = Database.getInstance().getConnection();
    private Chart chart = new Chart();

    public void createTable() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            statement.execute("create table if not exists chart(\n" +
                    "    id integer not null auto_increment,\n" +
                    "    album_name varchar(100) default '' not null,\n" +
                    "    listeners integer,\n" +
                    "    release_year integer not null,\n" +
                    "    primary key (id)\n" +
                    ");");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void create(String albumName, int listeners, int releaseYear) throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into chart (album_name, listeners, release_year) values (?, ?, ?)")) {
            preparedStatement.setString(1, albumName);
            preparedStatement.setInt(2,listeners);
            preparedStatement.setInt(3, releaseYear);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listenAlbum(String albumName) {
        Connection connection = Database.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("update chart set listeners=listeners+1 where album_name like '" + albumName + "'")) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void print() throws SQLException {
        connection = Database.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("select * from chart order by listeners desc");
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
            System.out.println("----------------------");
        }
    }

    public Chart getChart() {
        return this.chart;
    }
}

