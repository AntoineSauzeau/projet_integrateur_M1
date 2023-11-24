package ui;


import javax.swing.*;
import java.awt.*;
import java.util.List;


import model.Movie;
import model.PhysicalMovie;
import sql.Tool.Session;
import sql.dao.MovieDAO;
import sql.data.MovieService;

public class MovieGrid extends MoviePage {

    public MovieGrid(){

        int offset = 0;
        int max = 10;

        GridLayout grid = new GridLayout(0, 2, 15, 15);
        setLayout(grid);

        Session session = new Session(true);
        MovieService movieService = new MovieService(session);
        List<Movie> movies = movieService.getMovieInRange(offset,max);
        session.close();

        for (Movie movie: movies) {
            MovieCard movieCard = new MovieCard(movie);
            movieCard.setPreferredSize(new Dimension(250, 250));
            add(movieCard);
        }

        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }

    
}
