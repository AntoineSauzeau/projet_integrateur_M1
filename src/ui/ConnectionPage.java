package ui;


import model.Application;
import model.NonSubscriber;
import model.Subscriber;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// import static java.awt.event.MouseEvent.BUTTON1;


//Page de connexion en attente de l'identification du client
public class ConnectionPage extends JPanel {

    Interface interface_;
    JButton buttonNoSub;
    JButton buttonSub;

    //Faire deux boutons pour log subscriber et log non-subscriber
    public ConnectionPage() throws IOException {

        this.setLayout(new FlowLayout());

        buttonSub = new JButton("Log Sub");
        buttonSub.setIcon(new ImageIcon(ImageIO.read(new File("assets/img/log-inIcon.png"))));
        buttonSub.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonSub.setVerticalTextPosition(SwingConstants.BOTTOM);

        buttonNoSub = new JButton("Log Non-sub");
        buttonNoSub.setIcon(new ImageIcon(ImageIO.read(new File("assets/img/log-inIcon.png"))));
        buttonNoSub.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonNoSub.setVerticalTextPosition(SwingConstants.BOTTOM);

        this.add(buttonSub);
        this.add(buttonNoSub);

        setEventHandlers();
    }

    public void setEventHandlers(){

        buttonSub.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Application.setNewConnectedClient(new Subscriber());
                try {
                    Application.getInterface().changePage(InterfacePage.MAIN);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonNoSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.setNewConnectedClient(new NonSubscriber());
                try {
                    Application.getInterface().changePage(InterfacePage.MAIN);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
