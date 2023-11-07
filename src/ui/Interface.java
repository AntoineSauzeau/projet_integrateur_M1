package ui;

import javax.swing.*;
import java.awt.*;

public class Interface {

    static final int INTERFACE_WIDTH = 600;
    static final int INTERFACE_HEIGHT = 600;

    JFrame frame;
    InterfacePage page;


    public Interface(){

        page = InterfacePage.MAIN;

        frame = new JFrame("AL2000");
        frame.setMinimumSize(new Dimension(INTERFACE_WIDTH, INTERFACE_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changePage(InterfacePage.MAIN);
        frame.setVisible(true);

        //Faire pop la fenetre au centre
    }

    public void changePage(InterfacePage newPage){
        if(newPage == InterfacePage.MAIN){
            frame.add(new MainPage());
        }
    }
}
