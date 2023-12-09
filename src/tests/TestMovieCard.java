package tests;

import model.PhysicalMovie;
import ui.DisplayMovieCardType;
import ui.MovieCard;

import javax.swing.*;
import java.awt.*;

public class TestMovieCard {
    static JFrame frame;

    public static void main(String[] args) {
//TODO  régler taille image
        frame = new JFrame("MovieCard");
        frame.setMinimumSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PhysicalMovie movie = new PhysicalMovie();
        movie.setName("Oliver le Film");
        movie.setCategory("Animation");
        movie.setDirector("M.Mineau");
        movie.setSummary("BlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBla");
        movie.setId(2);
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        main.setBackground(Color.RED);
        main.add(new MovieCard(movie, DisplayMovieCardType.Page), BorderLayout.CENTER);

        frame.add(main);

        frame.setVisible(true);
    }
}
