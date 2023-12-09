package ui;

import javax.swing.*;
import java.awt.*;
import model.Movie;


//Page principale

public class MainPage extends JPanel {

    HeaderBar headerBar;
    SearchBar searchBar;
    JPanel centerPanel;
    //Désactiver/activer des fonctionnalité dans la page selon type de client + ajuster prix location

    public MainPage(){

        setLayout(new BorderLayout());
        setBackground(Color.green);
        //setPreferredSize(new Dimension(200, 200));

        headerBar = new HeaderBar();
        headerBar.setBackground(Color.gray);
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

    void showMovie(Movie movie) {
        this.remove(centerPanel);
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.blue);
        add(centerPanel, BorderLayout.CENTER);

        searchBar = new SearchBar();
        searchBar.setBackground(Color.yellow);
        searchBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        centerPanel.add(searchBar, BorderLayout.NORTH);

        centerPanel.add(new MovieClicked(movie), BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    /*void loadDefaultMenu(){
        this.remove(centerPanel);
        createCenterPanel();
        revalidate();
        repaint();
    }*/

    /*void loadAccountPage(){
        this.remove(centerPanel);
        centerPanel = new AccountPage();
        add(centerPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }*/
}
