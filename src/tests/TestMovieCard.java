package tests;

import model.Movie;
import model.PhysicalMovie;
import ui.Interface;
import ui.InterfacePage;
import ui.MovieCard;

import javax.swing.*;
import java.awt.*;

public class TestMovieCard {
    static JFrame frame;

    public static void main(String[] args) {

        frame = new JFrame("MovieCard");
        frame.setMinimumSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PhysicalMovie movie = new PhysicalMovie();
        movie.setName("Oliver le Film");
        movie.setCategory("Animation");
        movie.setDirector("M.Mineau");
        movie.setSummary("BlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBla");

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        main.setBackground(Color.RED);
        main.add(new MovieCard(movie), BorderLayout.CENTER);

        frame.add(main);

        frame.setVisible(true);
    }
}
