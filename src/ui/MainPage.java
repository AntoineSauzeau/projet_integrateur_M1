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

    public MainPage(JPanel centerPanel){
        setLayout(new BorderLayout());
        setBackground(Color.green);
        //setPreferredSize(new Dimension(200, 200));

        headerBar = new HeaderBar();
        headerBar.setBackground(Color.gray);
        add(headerBar, BorderLayout.PAGE_START);

        this.centerPanel = centerPanel;
        add(centerPanel, BorderLayout.CENTER);
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

    JPanel showResearchedMovies(JPanel movies){
        JPanel centerPanel_supp = new JPanel();
        for (Component comp : centerPanel.getComponents()) {
           centerPanel_supp.add(comp);
        }

        this.remove(centerPanel);
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.blue);

        searchBar = new SearchBar();
        searchBar.setBackground(Color.yellow);
        searchBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        centerPanel.add(searchBar, BorderLayout.NORTH);

        centerPanel.add(movies, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);
        repaint();
        revalidate();
        return centerPanel_supp;
    }


    void setContent(JPanel cp){
        for (Component component : centerPanel.getComponents()) {
            if (component instanceof MoviePanel) {
                centerPanel.remove(component);
                break;
            }
        }
        centerPanel.add(cp, BorderLayout.CENTER);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

}
