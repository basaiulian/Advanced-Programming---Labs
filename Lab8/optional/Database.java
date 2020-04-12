package com.company.lab8.compulsory;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/MusicAlbums";
    private static final String USER = "dba";
    private static final String PASSWORD = "sql";
    private static Connection connection = null;
    private static Database instance;

    private Database() {
        createConnection();
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    private static Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }


    public Connection getConnection() {
        return connection;
    }


    public static void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}