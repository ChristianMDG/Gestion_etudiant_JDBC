package org.example.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.Properties;

public class DbConnection {
    private Connection connection;
    public DbConnection() {
        try{
            Properties properties = new Properties();
            InputStream inputStream = DbConnection.class.getClassLoader().getResourceAsStream("db.properties");

            properties.load(Objects.requireNonNull(inputStream));
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
