package ui;

import javax.swing.*;
import java.awt.*;

public class Interface {

    static final int INTERFACE_WIDTH = 800;
    static final int INTERFACE_HEIGHT = 800;

    JFrame frame;
    InterfacePage page;


    public Interface() {

        page = InterfacePage.MAIN;

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

        if(newPage == InterfacePage.MAIN){
            frame.add(new MainPage());
        }
        else if(newPage == InterfacePage.CONNECTION){
            frame.add(new ConnectionPage());
        }
        else if(newPage == InterfacePage.ACCOUNT){
            frame.add(new AccountPage());
        }

        frame.revalidate();
        frame.repaint();
    }

    public void show(){
        frame.setVisible(true);
    }
}
