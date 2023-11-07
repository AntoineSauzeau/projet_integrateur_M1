package ui;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JPanel {

    HeaderBar headerBar;
    SearchBar searchBar;

    public MainPage(){

        setLayout(new BorderLayout());
        setBackground(Color.green);
        //setPreferredSize(new Dimension(200, 200));

        headerBar = new HeaderBar();
        headerBar.setBackground(Color.red);
        add(headerBar, BorderLayout.PAGE_START);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.blue);
        add(centerPanel, BorderLayout.CENTER);

        searchBar = new SearchBar();
        searchBar.setBackground(Color.yellow);
        searchBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        centerPanel.add(searchBar, BorderLayout.CENTER);
    }

}
