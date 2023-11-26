package ui;

import model.Movie;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle.Control;
import Controler.Controler;
import model.Movie;


public class MovieCard extends JPanel {
    Movie movie;

    public MovieCard(Movie movie){
        this.movie = movie;

        setLayout(new BorderLayout());

        setName("MovieCard");
        setBackground(Color.GREEN);

        //Panel de gauche et droite
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.YELLOW);
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.white);

        ImageIcon movieImageIcon;
        String pathname = "Images/"+movie.getId()+".jpg";
        System.out.println(movie.getId());

        try {
            movieImageIcon = new ImageIcon(ImageIO.read(new File(pathname)));
            //TODO ALLER chercher image du film
        } catch (IOException e) {
            //throw new RuntimeException(e);
            try {
                movieImageIcon = new ImageIcon(ImageIO.read(new File("assets/img/home.png")));
            }catch (IOException e2){
                throw new RuntimeException(e2);
            }
        }

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
