package ru.fintech.qa.homework.utils.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBClient {
    private Connection connection = null;

    public Connection getConnection() {
        if(connection == null){
            try {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql:localhost:5437/postgres","fintech","password");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }

}