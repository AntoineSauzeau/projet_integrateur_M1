package sql.Tool;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    public static Connection getConnection(boolean mode) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Spécifier l'URL de connexion à la base de données SQLite
        String url = "jdbc:sqlite:src/sql/database.db";

        // Établir la connexion
        Connection connexion = DriverManager.getConnection(url);

        System.out.println("Connexion à la base de données SQLite établie avec succès.");
        return connexion;
    }

}