package ui;


import javax.swing.*;
import java.awt.*;



import model.PhysicalMovie;

public class MovieGrid extends MoviePage {

    public MovieGrid(){
        PhysicalMovie movie = new PhysicalMovie();
        movie.setName("Esteban, ProFlecheur");
        movie.setCategory("Animation");
        movie.setDirector("M.Barneaud");
        movie.setSummary("Un film époustoufflant");
        GridLayout grid = new GridLayout(0, 2, 15, 15);
        setLayout(grid);
        for (int i = 0; i < 10; i++) {
            MovieCard movieCard = new MovieCard(movie);
            movieCard.setPreferredSize(new Dimension(250, 250));
            add(movieCard);
        }
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }

    
}
