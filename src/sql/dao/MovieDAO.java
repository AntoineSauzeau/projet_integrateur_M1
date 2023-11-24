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

        String sql = "SELECT * FROM Movies WHERE movieID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
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

        //String sql = "SELECT actorName FROM Movies JOIN MovieActors USING (movieID) USING Actors USING (movieID) WHERE id = ?";
        String sql = "SELECT actorName FROM Movies " +
                "JOIN MovieActors USING (movieID) " +
                "JOIN Actors USING (actorID) " +
                "WHERE movieID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, movieID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
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

        //String sql = "SELECT * FROM Movies m JOIN MoviesActors ma USING (movieID) JOIN Actors a USING (actorID) WHERE actorName = ?";
        String sql = "SELECT * FROM Movies m " +
                "JOIN MoviesActors ma ON m.movieID = ma.movieID " +
                "JOIN Actors a ON ma.actorID = a.actorID " +
                "WHERE actorName = ?";


        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if(result.next()){
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


    public List<Movie> getAll(int offset, int number){
        List<Movie> movies = new ArrayList<>();

        String sql = "SELECT * FROM Movies LIMIT ?, ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, offset);
            statement.setInt(2, number);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                Movie movie = new Movie();

                int id = result.getInt("movieID");
                movie.setId(id);
                movie.setName(result.getString("movieName"));
                //movie.setCategory(result.getString("category"));
                movie.setDirector(result.getString("directorName"));
                movie.setSummary(result.getString("summary"));
                movie.setMainActors(getActors(id));

                movies.add(movie);
            }
            return movies;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Movie> getByTitle(String title){
        List<Movie> movies = new ArrayList<>();

        String sql = "SELECT * FROM Movies WHERE movieName LIKE '%" + title + "%'";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();

            while(result.next()){
                Movie movie = new Movie();

                int id = result.getInt("movieID");
                movie.setId(id);
                movie.setName(result.getString("movieName"));
                //movie.setCategory(result.getString("category"));
                movie.setDirector(result.getString("directorName"));
                movie.setSummary(result.getString("summary"));
                movie.setMainActors(getActors(id));

                movies.add(movie);
            }
            return movies;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
