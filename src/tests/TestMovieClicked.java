package tests;

import model.PhysicalMovie;
import ui.MovieClicked;

import javax.swing.*;
import java.awt.*;

public class TestMovieClicked {
    static JFrame frame;

    public static void main(String[] args) {

        frame = new JFrame("MovieClicked");
        frame.setMinimumSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PhysicalMovie movie = new PhysicalMovie();
        movie.setName("Oliver le Film");
        movie.setCategory("Animation");
        movie.setDirector("M.Mineau");
        movie.setSummary("BlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBlaBla");

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        main.setBackground(Color.RED);
        main.add(new MovieClicked(movie), BorderLayout.CENTER);

        frame.add(main);    

        frame.setVisible(true);
    }
}