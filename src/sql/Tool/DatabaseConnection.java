package sql.Tool;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static Connection connexion = null;


    public static Connection getConnection(boolean mode) throws SQLException {
        if (connexion != null && !connexion.isClosed()) {
            return connexion;
        }
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Spécifier l'URL de connexion à la base de données SQLite
        String url = "jdbc:sqlite:src/sql/database.db";

        // Établir la connexion
        connexion = DriverManager.getConnection(url);

        System.out.println("Connexion à la base de données SQLite établie avec succès. test");
        return connexion;
    }

}