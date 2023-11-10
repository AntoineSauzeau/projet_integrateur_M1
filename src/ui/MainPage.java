package ui;

import javax.swing.*;
import java.awt.*;


//Page principale

public class MainPage extends JPanel {

    HeaderBar headerBar;
    SearchBar searchBar;
    JPanel centerPanel;
    //Désactiver/activer des fonctionnalité dans la page selon type de client + ajuster prix location
    Boolean Subscribed = false;

    public MainPage(int sub){

        if(sub == 1){
            Subscribed = true;
        }

        setLayout(new BorderLayout());
        setBackground(Color.green);
        //setPreferredSize(new Dimension(200, 200));

        headerBar = new HeaderBar(this);
        headerBar.setBackground(Color.red);
        add(headerBar, BorderLayout.PAGE_START);

        createCenterPanel();


        
    }

    void createCenterPanel(){
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.blue);
        add(centerPanel, BorderLayout.CENTER);
        searchBar = new SearchBar();
        searchBar.setBackground(Color.yellow);
        searchBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        centerPanel.add(searchBar, BorderLayout.NORTH);

        centerPanel.add(new MoviePanel(), BorderLayout.CENTER);
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

    void loadDefaultMenu(){
        this.remove(centerPanel);
        createCenterPanel();
        revalidate();
        repaint();
    }
}
