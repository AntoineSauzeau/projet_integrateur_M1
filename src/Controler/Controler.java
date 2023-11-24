package Controler;
import ui.Interface;
import ui.InterfacePage;
import model.Movie;

public class Controler {
    Interface ui;
    //Singleton
    private static Controler instance = null;

    public static Controler getInstance() {
        if (instance == null) {
            throw new RuntimeException("Controler not initialized");
        }
        return instance;
    }


    
    public Controler(Interface ui) {
        this.ui = ui;
        instance = this;
    }

    public void changePage(InterfacePage newPage) {
        ui.changePage(newPage);
    }

    public void showMovie(Movie movie) {
        ui.showMovie(movie);    
    }


}
