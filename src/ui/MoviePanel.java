package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class MoviePanel extends JPanel{
    
    public MoviePanel(){
        setLayout(new GridLayout(2,1,5 ,5));
        setBackground(java.awt.Color.LIGHT_GRAY);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel movieAlaUneListe = new MovieSlide();
        movieAlaUneListe.setBackground(java.awt.Color.BLACK);
        JScrollPane movieAlaUneScroll = new JScrollPane(movieAlaUneListe);
        movieAlaUneScroll.setPreferredSize(new java.awt.Dimension(250, 250));
        JPanel movieAlaUne = new JPanel();
        movieAlaUne.setLayout(new BorderLayout());
        movieAlaUne.add(BorderLayout.CENTER, movieAlaUneScroll);
        // Texte centré en haut en police 40 et en blanc
        JLabel label = new JLabel("A LA UNE", SwingConstants.CENTER);
        label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 40));
        label.setForeground(java.awt.Color.WHITE);
        movieAlaUne.add(label,BorderLayout.NORTH);
        movieAlaUne.setBackground(java.awt.Color.BLACK);

        JPanel movieDispoListe = new MovieGrid();
        movieDispoListe.setBackground(java.awt.Color.GRAY);
        // Scroll vertical sur la liste des films
        JScrollPane movieDispoScroll = new JScrollPane(movieDispoListe);
        movieDispoScroll.setPreferredSize(new java.awt.Dimension(250, 250));
        JPanel movieDispo = new JPanel();
        movieDispo.setLayout(new BorderLayout());
        movieDispo.add(movieDispoScroll,BorderLayout.CENTER);
        JLabel label2 = new JLabel("DISPONIBLES", SwingConstants.CENTER);
        label2.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 40));
        label2.setForeground(java.awt.Color.GRAY);
        movieDispo.add( label2,BorderLayout.NORTH);
        

        add(movieAlaUne);
        add(movieDispo);
    }
}
