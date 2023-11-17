package ui;

import javax.swing.*;
import java.awt.*;


import model.PhysicalMovie;

public class MovieSlide extends MoviePage{

    public MovieSlide(){
        PhysicalMovie movie = new PhysicalMovie();
        movie.setName("Esteban, ProFlecheur");
        movie.setCategory("Animation");
        movie.setDirector("M.Barneaud");
        movie.setSummary("Un film époustoufflant");
        for (int i = 0; i < 4; i++) {
            add(new MovieCard(movie));
        }
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridLayout grid = new GridLayout(1, 1, 15, 15);
        setLayout(grid);
    }
}
