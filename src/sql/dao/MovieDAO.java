package sql.dao;

import model.Movie;
import model.Subscriber;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    private Connection connection; // L'objet de connexion à la base de données

    // Constructeur pour injecter la connexion
    public MovieDAO(Connection connection) {
        this.connection = connection;
    }

    public Movie getById(int id){
        Movie movie = null;

        String sql = "SELECT * FROM Movies WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.first()){
                movie = new Movie();

                movie.setId(id);
                movie.setName(result.getString("movieName"));
                movie.setCategory(result.getString("category"));
                movie.setDirector(result.getString("directorName"));
                movie.setSummary(result.getString("summary"));
                movie.setMainActors(getActors(id));

                return movie;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    private ArrayList<String> getActors(int movieID){
        ArrayList<String> actors = new ArrayList<String>();

        String sql = "SELECT actorName FROM Movies JOIN MovieActors USING(movieID) USING Actors USING (movieID) WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, movieID);
            ResultSet result = statement.executeQuery();
            if (result.first()) {
                while(result.isAfterLast()){
                    actors.add(result.getString("actorName"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    public Movie getByActor(String name){

        String sql = "SELECT * FROM Movies m JOIN MoviesActors ma USING(movieID) JOIN Actors a USING (actorID) WHERE actorName = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if(result.first()){
                Movie movie = new Movie();

                movie.setId(result.getInt("movieID"));
                movie.setName(result.getString("movieName"));
                movie.setCategory(result.getString("category"));
                movie.setDirector(result.getString("directorName"));
                movie.setSummary(result.getString("summary"));
                movie.setMainActors(getActors(result.getInt("movieID")));

                return movie;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
