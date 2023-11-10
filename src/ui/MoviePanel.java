package ui;

import java.awt.GridLayout;

import javax.swing.*;

public class MoviePanel extends JPanel{
    
    public MoviePanel(){
        setLayout(new GridLayout(2,1,5 ,5));
        setBackground(java.awt.Color.LIGHT_GRAY);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel movieAlaUne = new MoviePage();
        movieAlaUne.setBackground(java.awt.Color.BLACK);
        JPanel movieDispo = new MoviePage();    
        movieDispo.setBackground(java.awt.Color.GRAY);
        add(movieAlaUne);
        add(movieDispo);
    }
}
