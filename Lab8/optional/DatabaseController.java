package com.company.lab8.compulsory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseController {

    public void createTables() {
        Connection connection;
        Statement statement = null;

        try {
            connection = Database.getInstance().getConnection();
            statement = connection.createStatement();
            statement.execute("create table if not exists artists(\n" +
                    "    id integer not null auto_increment,\n" +
                    "    name varchar(100) not null,\n" +
                    "    country varchar(100),\n" +
                    "    primary key (id)\n" +
                    ");");
            statement.execute("create table if not exists albums(\n" +
                    "    id integer not null auto_increment,\n" +
                    "    name varchar(100) not null,\n" +
                    "    artist_id integer not null references artists on delete restrict,\n" +
                    "    release_year integer,\n" +
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

    public void closeConnection()
    {
        Connection con = Database.getInstance().getConnection();
        if(con!=null)
        {
            try {
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}