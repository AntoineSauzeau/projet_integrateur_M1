package Controler;
import ui.Interface;
import ui.InterfacePage;

import javax.swing.JPanel;

import sql.Tool.Session;
import sql.data.RentService;
import model.*;



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

    public void goBack() {
        ui.goBack();
    }

    public void changePrec(JPanel panel) {
        ui.changePrec(panel);
    }

    public void chargeMain(JPanel panel) {
        ui.chargeMain(panel);
    }

    public void rentMovie(Movie movie) {
        Subscriber s = Application.getSubcriberConnected();
        Rent r = new Rent(movie,s,0);
        Session session = new Session(true);
        RentService rdao = new RentService(session);
        rdao.addRent(r);

    }


}
