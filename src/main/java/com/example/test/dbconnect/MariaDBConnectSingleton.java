package com.example.test.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MariaDBConnectSingleton {
    private final static MariaDBConnectSingleton dbConnect = new MariaDBConnectSingleton();
    private Connection connection;

    private static final String URL = "jdbc:mariadb://localhost:3306/game_spring_api";
    private static final String USER = "paulm";
    private static final String PASSWORD = "toto";

    private MariaDBConnectSingleton() {
        try {
            // Charger le driver JDBC
            Class.forName("org.mariadb.jdbc.Driver");
            // Créer la connexion
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion à la base de données établie !");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC non trouvé : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
        }
    }

    public static MariaDBConnectSingleton getInstance() {
        return dbConnect;
    }
    
    public Connection getConnection() {
        return connection;
    }
}
