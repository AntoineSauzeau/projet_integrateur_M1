package ui;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JPanel {

    HeaderBar headerBar;
    SearchBar searchBar;
    FilmList frontPageFl;
    FilmList avFilmListFl;

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
        centerPanel.add(searchBar);

        JPanel frontPageFilmsPanel = createFrontPageFilmsPanel();
        centerPanel.add(frontPageFilmsPanel);

        /*JPanel availableFilmsPanel = createAvailableFilmsPanel();
        centerPanel.add(availableFilmsPanel);*/
    }

    JPanel createFrontPageFilmsPanel(){
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        JLabel labelTitle = new JLabel("Films à la une");
        p.add(labelTitle);

        return p;
    }

    JPanel createAvailableFilmsPanel(){
        return null;
    }
}
