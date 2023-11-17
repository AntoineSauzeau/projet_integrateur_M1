package ui;



import javax.swing.*;
import java.util.ArrayList;

import model.PhysicalMovie;

public abstract class MoviePage extends JPanel {

    ArrayList<PhysicalMovie> movies;

    public void setMovies(ArrayList<PhysicalMovie> movies) {
        this.movies = movies;
    }

}
