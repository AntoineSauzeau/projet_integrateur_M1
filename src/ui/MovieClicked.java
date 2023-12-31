package ui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import model.Movie;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import Controler.Controler;
import model.Application;

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

        bouton_louer_br.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // TODO: Louer le film en Blu-Ray (appel BD, affichage message de confirmation)
                String messageDialogConfirmation = "Le film " +movie.getName() +" a bien été loué.\nBon visionnage !";
                if(Application.clientIsSubscriber()){
                    Float solde = Application.getSubcriberConnected().getBalance();
                    if(solde-4 < 0) {
                        JDialog dialog = new Confirmation(null, "Echec de la location", "Solde insuffisant. Veuillez recharger votre compte");
                        dialog.setVisible(true);
                        return;
                    }
                    Application.getSubcriberConnected().setBalance(solde - 4);
                    messageDialogConfirmation += "\n\nVotre nouveau solde est de " +Application.getSubcriberConnected().getBalance() +"€.";
                }

                Controler.getInstance().rentMovie(movie);
                JDialog dialog = new Confirmation(null, "Confirmation de votre location", messageDialogConfirmation);
                dialog.setVisible(true);
            }
        });

        JButton bouton_louer_qr = new JButton("Louer ce film en version numérique");
        //bouton_louer_qr.setBackground(java.awt.Color.BLACK);
        bouton_louer_qr.setForeground(java.awt.Color.BLACK);
        bouton_louer_qr.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));

        bouton_louer_qr.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // TODO: Louer le film en version numérique (appel BD, affichage message de confirmation)
            }
        });


        JButton bouton_retour = new JButton(" ← ");
        // Bouton gris avec le texte en blanc
        bouton_retour.setForeground(java.awt.Color.GRAY);
        bouton_retour.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));

        bouton_retour.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Controler.getInstance().goBack();
            }
        });



        // Afficher les deux boutons centrés en bas de la page
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(bouton_louer_br);
        buttonPanel.add(bouton_louer_qr);
        buttonPanel.add(bouton_retour);

        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(new MovieCard(movie, DisplayMovieCardType.Page), BorderLayout.CENTER);


    }
    
    
}
