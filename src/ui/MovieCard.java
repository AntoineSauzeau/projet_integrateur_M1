package ui;

import model.Movie;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class MovieCard extends JPanel {

    public MovieCard(Movie movie){

        setLayout(new BorderLayout());

        setName("MovieCard");
        setBackground(Color.GREEN);

        //Panel de gauche et droite
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.YELLOW);
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.white);

        //Image du film
        ImageIcon movieImageIcon;
        try {
            movieImageIcon = new ImageIcon(ImageIO.read(new File("assets/img/home.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JLabel movieImage = new JLabel(movieImageIcon);
        leftPanel.add(movieImage, BorderLayout.CENTER);


        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(movie.getName() + movie.getName(),JLabel.LEFT);
        JLabel director = new JLabel(movie.getDirector());
        JLabel category = new JLabel(movie.getCategory());


        JLabel tout = new JLabel("<html>" + movie.getName() + "<br>"+ movie.getCategory() +"<br>"+ movie.getDirector() + "</html>",JLabel.LEFT);

        textPanel.add(title);
        textPanel.add(director);
        textPanel.add(category);

        rightPanel.add(tout, BorderLayout.CENTER);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,2));

        center.add(leftPanel);
        center.add(rightPanel);

        add(center, BorderLayout.CENTER);
    }

}
