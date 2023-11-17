package ui;

import java.awt.GridLayout;

import javax.swing.*;

public class MoviePanel extends JPanel{
    
    public MoviePanel(){
        setLayout(new GridLayout(2,1,5 ,5));
        setBackground(java.awt.Color.LIGHT_GRAY);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel movieAlaUne = new MovieSlide();
        movieAlaUne.setBackground(java.awt.Color.BLACK);
        JScrollPane movieAlaUneScroll = new JScrollPane(movieAlaUne);
        movieAlaUneScroll.setPreferredSize(new java.awt.Dimension(250, 250));
        JPanel movieDispo = new MovieGrid();
        movieDispo.setBackground(java.awt.Color.GRAY);
        // Scroll vertical sur la liste des films
        JScrollPane movieDispoScroll = new JScrollPane(movieDispo);
        movieDispoScroll.setPreferredSize(new java.awt.Dimension(250, 250));
        

        add(movieAlaUneScroll);
        add(movieDispoScroll);
    }
}
