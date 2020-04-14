package com.company.lab8.compulsory;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            preparedStatement.setInt(2, listeners);
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

    public void report() throws IOException, SQLException {
        final StringBuilder stringBuilder = new StringBuilder();
        final BufferedWriter bufferedWriter;
        PreparedStatement statement;
        ResultSet resultSet;
        Desktop desktopManager = Desktop.getDesktop();
        int counter;

        statement = connection.prepareStatement("select album_name, listeners from chart order by listeners desc");
        statement.executeQuery();
        resultSet = statement.getResultSet();


        stringBuilder.append(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        " <meta charset=\"UTF-8\">\n" +
                        " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        " <link href=\"https://fonts.googleapis.com/css2?family=Girassol&display=swap\" rel=\"stylesheet\">\n" +
                        " <title>Chart</title>\n\n" +
                        " <style>\n" +
                        "    table {\n" +
                        "        margin: auto;\n" +
                        "        font-family: 'Girassol', cursive;\n" +
                        "        position: relative;\n" +
                        "        top: 20px;\n" +
                        "        width: 40%;\n" +
                        "    }\n\n" +

                        "    th, td {\n" +
                        "        padding: 5px 60px;\n" +
                        "        border: 2px;\n" +
                        "    }\n\n" +

                        "    img {\n" +
                        "       width: 4vw;\n" +
                        "     }\n\n" +

                        "    #text{\n" +
                        "      position: absolute;\n" +
                        "      top: 2%;\n" +
                        "      left: 5%;\n" +
                        "      font-family: 'Girassol', cursive;\n" +
                        "      font-size:2vw;\n" +
                        "     }\n\n" +
                        " </style>\n" +

                        "</head>\n" +

                        "<body>\n" +
                        " <table border=\"1\">" +
                        "    <img src=\"logo.png\" alt=\"Logo\">" +
                        "<div id=\"text\"> Chart </div>" +
                        " <tr>\n" +
                        " <th>Rank</th>\n" +
                        " <th>Album name</th>\n" +
                        " <th>Listeners</th>\n" +
                        " </tr>"
        );

        counter = 1;
        while (resultSet.next()) {
            stringBuilder.append("<tr>\n");
            stringBuilder.append("<td>").append(counter).append("</td>\n");
            stringBuilder.append("<td>").append(resultSet.getString(1)).append("</td>\n");
            stringBuilder.append("<td>").append(resultSet.getInt(2)).append("</td>\n");
            stringBuilder.append("</tr>\n\n");
            counter++;
        }

        stringBuilder.append("</table>\n" + "</body>\n" + "</html>");

        bufferedWriter = new BufferedWriter(new FileWriter("report.html"));
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.close();

        System.out.println("HTML Report created.");
        desktopManager.open(new File("report.html"));
    }

    public Chart getChart() {
        return this.chart;
    }
}

