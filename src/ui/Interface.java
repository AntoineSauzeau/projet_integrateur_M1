package ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Interface {

    static final int INTERFACE_WIDTH = 800;
    static final int INTERFACE_HEIGHT = 800;

    JFrame frame;
    InterfacePage page;


    public Interface() throws IOException {

        page = InterfacePage.MAIN;

        frame = new JFrame("AL2000");
        frame.setMinimumSize(new Dimension(INTERFACE_WIDTH, INTERFACE_HEIGHT));
        // frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changePage(InterfacePage.MAIN);
        frame.setVisible(true);

        //Faire pop la fenetre au centre
    }

    public void changePage(InterfacePage newPage) throws IOException {
        if(newPage == InterfacePage.MAIN){
            frame.add(new ConnectionPage());
        }
    }
}
