package ui;

import model.Movie;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import Controler.Controler;


public class MovieCard extends JPanel {
    Movie movie;
    DisplayMovieCardType display;

    public MovieCard(Movie movie, DisplayMovieCardType dis){
        this.movie = movie;
        display = dis;
        setLayout(new BorderLayout());

        setName("MovieCard");
        setBackground(Color.GREEN);

        //Panel de gauche et droite
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.BLACK);
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.white);


        //Image du film
        ImageIcon movieImageIcon;
        BufferedImage poster;
        Image scaledPoster = null;
        String pathname = "Images/Movie Poster"+movie.getId()+".jpg"; // Chemin de l'image si elle existe
        String defaultPathname = "assets/img/home.png";
        try {
            poster = ImageIO.read(new File(pathname));
        } catch (IOException e) {
            //Si on ne trouve pas l'image du film, on en met une par default
            try {
                poster = ImageIO.read(new File(defaultPathname));
            }catch (IOException e2){
                throw new RuntimeException(e2);
            }
        }
        switch (dis){
            case Grid:
                scaledPoster = poster.getScaledInstance(160, 250, Image.SCALE_SMOOTH);
                break;
            case Page:
                scaledPoster = poster.getScaledInstance(300, 600, Image.SCALE_SMOOTH);
                break;
            case Slide:
                scaledPoster = poster.getScaledInstance(125, 215, Image.SCALE_SMOOTH);
            break;
        }
        movieImageIcon = new ImageIcon(scaledPoster);

        JLabel movieImage = new JLabel(movieImageIcon);
        leftPanel.add(movieImage, BorderLayout.CENTER);


        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(movie.getName() + movie.getName(),JLabel.LEFT);
        JLabel director = new JLabel(movie.getDirector());
        JLabel category = new JLabel(movie.getCategory());


        JLabel tout = new JLabel("<html>" + movie.getName() +"<br>"+ movie.getDirector() + "<br><br>" + movie.getSummary() + "</html>",JLabel.LEFT);

        textPanel.add(title);
        textPanel.add(director);
        textPanel.add(category);

        rightPanel.add(tout, BorderLayout.CENTER);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,2));

        center.add(leftPanel);
        center.add(rightPanel);

        add(center, BorderLayout.CENTER);
        // Ajoute un listener sur un clic sur le panel
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Controler.getInstance().showMovie(movie);
            }
        });
    }

}
