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

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        bttnSearch = new JLabel(iconSearch);
        tfSearch = new JTextField();

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
