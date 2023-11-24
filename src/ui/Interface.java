package ui;

import javax.swing.*;

import Controler.Controler;
import model.Movie;

import java.awt.*;

public class Interface {

    static final int INTERFACE_WIDTH = 800;
    static final int INTERFACE_HEIGHT = 800;

    JFrame frame;
    InterfacePage page;
    JPanel win;


    public Interface() {

        page = InterfacePage.MAIN;
        Controler ctrl = new Controler(this);

        frame = new JFrame("AL2000");
        frame.setMinimumSize(new Dimension(INTERFACE_WIDTH, INTERFACE_HEIGHT));
        // frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changePage(InterfacePage.CONNECTION);

        //Faire pop la fenetre au centre
    }

    public void changePage(InterfacePage newPage) {
        frame.getContentPane().removeAll();

        win = null;
        if(newPage == InterfacePage.MAIN){
            win = new MainPage();
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

        frame.revalidate();
        frame.repaint();
    }

    public void show(){
        frame.setVisible(true);
    }

    public void showMovie(Movie movie) {
        ((MainPage) win).showMovie(movie);
    }
}
