package ui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import model.Movie;
import sql.Tool.Session;
import sql.data.MovieService;

public class ResearchPage extends JPanel {

    private HeaderBar headerBar;
    private SearchBar searchBar;
    private JPanel centerPanel;
    private JPanel grid;


    public ResearchPage() {
        setLayout(new BorderLayout());
        setBackground(Color.green);
        //setPreferredSize(new Dimension(200, 200));

        headerBar = new HeaderBar();
        headerBar.setBackground(Color.gray);
        add(headerBar, BorderLayout.PAGE_START);

        setLayout(new BorderLayout());
        setBackground(Color.green);
        //setPreferredSize(new Dimension(200, 200));

        headerBar = new HeaderBar();
        headerBar.setBackground(Color.gray);
        add(headerBar, BorderLayout.PAGE_START);

        createCenterPanel();
    }

    public void createCenterPanel() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.blue);
        add(centerPanel, BorderLayout.CENTER);

        searchBar = new SearchBar();
        searchBar.setBackground(Color.yellow);
        searchBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        centerPanel.add(searchBar, BorderLayout.NORTH);

        grid = new MovieGrid();
        centerPanel.add(grid, BorderLayout.CENTER);
    }

    public void createCenterPanel(MovieGrid grid) {
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.blue);
        add(centerPanel, BorderLayout.CENTER);

        searchBar.setBackground(Color.yellow);
        searchBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        centerPanel.add(searchBar, BorderLayout.NORTH);

        centerPanel.add(grid, BorderLayout.CENTER);
    }



    public void setText(String text) {
        searchBar.setText(text);
    }

    public void update() {
        this.remove(centerPanel);
        createCenterPanel(new MovieGrid(getRelevantMovies(searchBar.getText())));
        revalidate();
        repaint();
    }

    public void showMovie(Movie movie) {
        this.remove(centerPanel);
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.blue);
        add(centerPanel, BorderLayout.CENTER);

        searchBar.setBackground(Color.yellow);
        searchBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        centerPanel.add(searchBar, BorderLayout.NORTH);

        centerPanel.add(new MovieClicked(movie), BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    public List<Movie> getRelevantMovies(String title){

        Session session = new Session(true);
        MovieService movieService = new MovieService(session);
        List<Movie> movies = movieService.getMovieByTitle(title);
        session.close();

        return movies;
    }

    
}
