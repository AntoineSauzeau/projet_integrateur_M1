package ui;

import javax.swing.*;

import Controler.Controler;
import model.Movie;

import Controler.CreatorThread;
import ui.InterfacePage;

import java.awt.*;
import java.util.ArrayList;

public class Interface {

    static final int INTERFACE_WIDTH = 800;
    static final int INTERFACE_HEIGHT = 800;

    JFrame frame;
    InterfacePage page;
    JPanel win;
    JPanel prec;
    JPanel main;
    JPanel content;

    public Interface() {

        page = InterfacePage.MAIN;
        new Controler(this);

        frame = new JFrame("AL2000");
        frame.setMinimumSize(new Dimension(INTERFACE_WIDTH, INTERFACE_HEIGHT));
        // frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changePage(InterfacePage.CONNECTION);
        prec = null;
        CreatorThread creator = new CreatorThread("MAIN","MAIN_PAGE");
        creator.execute();
    }

    public void changePage(InterfacePage newPage) {
        frame.getContentPane().removeAll();

        win = null;
        if(newPage == InterfacePage.MAIN){
            if (main == null) {
                win = new MainPage();
            }
            else {
                win = main;
            }
            frame.add(win);
        }
        else if(newPage == InterfacePage.CONNECTION){
            win = new ConnectionPage();
            frame.add(win);
        }
        else if(newPage == InterfacePage.ACCOUNT){
            win = new AccountPage();
            frame.add(win);
        } 
        else if (newPage == InterfacePage.RESEARCH){
            win = new ResearchPage();
            frame.add(win);
        }
        prec = win;
        frame.revalidate();
        frame.repaint();
    }

    public void goBack(){
        if(prec != null){
            frame.getContentPane().removeAll();
            frame.add(prec);
            frame.revalidate();
            frame.repaint();
            win = prec;
            prec = null;
        }
    }

    public void show(){
        frame.setVisible(true);
    }

    public void changePrec(JPanel prec){
        this.prec = prec;
    }

    public void showMovie(Movie movie) {
        CreatorThread creator = new CreatorThread("MAIN","MAIN_PAGE");
        creator.execute();
        CreatorThread creator2 = new CreatorThread("PREC","MAIN_PAGE");
        creator2.execute();
        switch (Controler.getInstance().getPage()) {
            case MAIN:
                ((MainPage) win).showMovie(movie);
                break;
            case RESEARCH:
                ((ResearchPage) win).showMovie(movie);
                break;
            default:
                break;
        }
    }

    public void chargeMain(JPanel panel){
        this.main = panel;
    }

    public void showResearchedMovies(JPanel movies) {
        ((MainPage) win).setContent(movies);
        content = movies;
    }

    public void updateResearchedMovies() {
        ((ResearchPage) win).update();
    }

    public void setSearch(String text) {
        try{((ResearchPage) win).setText(text);}
        catch(Exception e){((MainPage) win).setText(text);}
    }
}
