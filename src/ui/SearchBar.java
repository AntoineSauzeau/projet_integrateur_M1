package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SearchBar extends JPanel {

    ImageIcon iconSearch;
    JLabel bttnSearch;
    JTextField tfSearch;

    public SearchBar(){

        loadIcons();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        bttnSearch = new JLabel(iconSearch);
        c.gridx = 0;
        c.gridy = 0;
        add(bttnSearch, c);

        tfSearch = new JTextField();
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.8;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(tfSearch, c);
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
