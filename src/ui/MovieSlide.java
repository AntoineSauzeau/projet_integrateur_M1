package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;


import model.Movie;
import sql.Tool.Session;
import sql.data.MovieService;

public class MovieSlide extends MoviePage{

    public MovieSlide(){

        Session session = new Session(true);
        MovieService movieService = new MovieService(session);
        //TODO : Chercher movies à la une
        List<Movie> movies = movieService.getTopTenMovies();
        //session.close();

        for (Movie movie: movies) {
            MovieCard movieCard = new MovieCard(movie, DisplayMovieCardType.Slide);
            movieCard.setPreferredSize(new Dimension(250, 250));
            add(movieCard);
        }

        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridLayout grid = new GridLayout(1, 1, 15, 15);
        setLayout(grid);
    }
}
