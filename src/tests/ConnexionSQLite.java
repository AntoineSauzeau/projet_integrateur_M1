package tests;

import model.Movie;
import sql.dao.MovieDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConnexionSQLite {
    static Connection connexion = null;

    public static void main(String[] args) {

        try {
            // Charger le pilote JDBC SQLite
            Class.forName("org.sqlite.JDBC");

            // Spécifier l'URL de connexion à la base de données SQLite
            String url = "jdbc:sqlite:src/sql/database.db";

            // Établir la connexion
            connexion = DriverManager.getConnection(url);

            System.out.println("Connexion à la base de données SQLite établie avec succès.");

            MovieDAO movieDAO = new MovieDAO(connexion);
            System.out.println(movieDAO.getAll(0, 10));

            // Vous pouvez maintenant exécuter des requêtes sur la base de données...

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Assurez-vous de fermer la connexion dans le bloc finally pour éviter les fuites de ressources
            try {
                if (connexion != null && !connexion.isClosed()) {
                    connexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Movie> getAllMovies(int offset, int number){
        MovieDAO movieDAO = new MovieDAO(connexion);
        return movieDAO.getAll(0, 10);
    }

}
