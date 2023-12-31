package sql.data;

import model.Movie;
import sql.Tool.Session;
import sql.dao.MovieDAO;

import java.sql.SQLException;
import java.util.List;

public class MovieService {
    private MovieDAO movieDAO;
    private Session session;

    // Constructeur pour injecter la connexion, le DAO et le gestionnaire de transactions
    public MovieService(Session session) {
        this.session = session;
    }

    public List<Movie> getMovieInRange(int offset, int max){
        try {
            session.open();

            movieDAO = new MovieDAO(session.get());
            List<Movie> movies = movieDAO.getAll(offset,max);
            //session.close();
            return movies;

        } catch (SQLException e) {
        }
        return null;
    }

    public List<Movie> getMovieByTitle(String title){
        try {
            session.open();
            movieDAO = new MovieDAO(session.get());
            List<Movie> movies = movieDAO.getByTitle(title);
            //session.close();
            return movies;

        } catch (SQLException e) {
        }
        return null;
    }

    public List<Movie> getTopTenMovies(){
        try {
            session.open();
            movieDAO = new MovieDAO(session.get());
            List<Movie> movies = movieDAO.getTopTen();
            //session.close();
            return movies;

        } catch (SQLException e) {
        }
        return null;
    }

}


