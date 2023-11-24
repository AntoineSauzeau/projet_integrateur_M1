package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.io.File;
import java.io.IOException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class SearchBar extends JPanel {

    ImageIcon iconSearch;
    JLabel bttnSearch;
    JTextField tfSearch;

    public SearchBar(){

        loadIcons();

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        bttnSearch = new JLabel(iconSearch);
        tfSearch = new JTextField();
        // A chaque caractère ajouté dans le textfield, on l'affiche dans la console
        tfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println(tfSearch.getText());
                System.out.println("Ajoute");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println(tfSearch.getText());
                System.out.println("Supprime");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println(tfSearch.getText());
                System.out.println("Change");
            }
        });


        add(tfSearch);
        add(bttnSearch);
    }

    public void loadIcons(){
        try {
            iconSearch = new ImageIcon(ImageIO.read(new File("assets/img/search.png")));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
