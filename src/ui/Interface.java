package ui;

import javax.swing.*;

import Controler.Controler;
import model.Movie;

import Controler.CreatorThread;

import java.awt.*;

public class Interface {

    static final int INTERFACE_WIDTH = 800;
    static final int INTERFACE_HEIGHT = 800;

    JFrame frame;
    InterfacePage page;
    JPanel win;
    JPanel prec;
    JPanel main;

    public Interface() {

        page = InterfacePage.MAIN;
        Controler ctrl = new Controler(this);

        frame = new JFrame("AL2000");
        frame.setMinimumSize(new Dimension(INTERFACE_WIDTH, INTERFACE_HEIGHT));
        // frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changePage(InterfacePage.CONNECTION);
        prec = null;
        CreatorThread creator = new CreatorThread("MAIN","MAIN_PAGE");
        creator.execute();


        //Faire pop la fenetre au centre
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
        CreatorThread creator = new CreatorThread("PREC","MAIN_PAGE");
        creator.execute();
        //prec = new MainPage();
        ((MainPage) win).showMovie(movie);
    }

    public void chargeMain(JPanel panel){
        this.main = panel;
    }
}
