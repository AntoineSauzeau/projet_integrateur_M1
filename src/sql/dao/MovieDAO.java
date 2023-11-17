package sql.dao;

import model.Movie;
import model.Subscriber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDAO {

    private Connection connection; // L'objet de connexion à la base de données

    // Constructeur pour injecter la connexion
    public MovieDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Movie m){

    }

    public Movie getById(int id){

        String sql = "SELECT * FROM Movies WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.first()){
                Movie movie = new Movie();

                movie.setId(id);
                movie.setName(result.getString("movieName"));
                movie.setCategory(result.getString("category"));
                movie.setDirector(result.getString("directorName"));
                movie.setSummary(result.getString("summary"));

                //TODO Decouper les acteurs en liste
                /*result.getString("actorsName")
                movie.setMainActors();*/

                return movie;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
