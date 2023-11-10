package ui;

import javax.swing.*;
import java.awt.*;


//Page principale

public class MainPage extends JPanel {

    HeaderBar headerBar;
    SearchBar searchBar;
    //Désactiver/activer des fonctionnalité dans la page selon type de client + ajuster prix location
    Boolean Subscribed = false;

    public MainPage(){

        setLayout(new BorderLayout());
        setBackground(Color.green);
        //setPreferredSize(new Dimension(200, 200));

        headerBar = new HeaderBar();
        headerBar.setBackground(Color.red);
        add(headerBar, BorderLayout.PAGE_START);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(Color.blue);
        add(centerPanel, BorderLayout.CENTER);

        addSearchBar(centerPanel);
        addFrontPageFilmsPanel(centerPanel);
        addAvailableFilmsPanel(centerPanel);
    }

    void addSearchBar(JPanel parent){
        searchBar = new SearchBar();
        searchBar.setBackground(Color.yellow);
        //searchBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;

        parent.add(searchBar, c);
    }

    JPanel createFrontPageFilmsPanel(){
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        JLabel labelTitle = new JLabel("Films à la une");
        p.add(labelTitle);

        return p;
    }

    void addFrontPageFilmsPanel(JPanel parent){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.3;

        JPanel frontPageFilmsPanel = createFrontPageFilmsPanel();
        parent.add(frontPageFilmsPanel, c);
    }

    JPanel createAvailableFilmsPanel(){
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        JLabel labelTitle = new JLabel("Films disponibles");
        p.add(labelTitle);

        return p;
    }

    void addAvailableFilmsPanel(JPanel parent){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 0.5;

        JPanel availableFilmsPanel = createAvailableFilmsPanel();
        parent.add(availableFilmsPanel, c);
    }
}
