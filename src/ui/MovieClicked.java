package ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import model.Movie;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class MovieClicked extends JPanel {

    Movie movie;

    public MovieClicked(Movie movie) {
        this.movie = movie;

        this.setLayout(new BorderLayout());
        this.setBackground(java.awt.Color.LIGHT_GRAY);

        JButton bouton_louer_br = new JButton("Louer ce film en Blu-Ray");
        // Bouton en fond noir avec marqué "Louer" en blanc
        //bouton_louer_br.setBackground(java.awt.Color.BLACK);
        bouton_louer_br.setForeground(java.awt.Color.BLACK);
        bouton_louer_br.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));

        JButton bouton_louer_qr = new JButton("Louer ce film en version numérique");
        //bouton_louer_qr.setBackground(java.awt.Color.BLACK);
        bouton_louer_qr.setForeground(java.awt.Color.BLACK);
        bouton_louer_qr.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));

        JButton bouton_retour = new JButton(" ◀ ");
        // Bouton gris avec le texte en blanc
        bouton_retour.setForeground(java.awt.Color.GRAY);
        bouton_retour.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));



        // Afficher les deux boutons centrés en bas de la page
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(bouton_louer_br);
        buttonPanel.add(bouton_louer_qr);
        buttonPanel.add(bouton_retour);

        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(new MovieCard(movie, DisplayMovieCardType.Page), BorderLayout.CENTER);


    }
    
    
}
