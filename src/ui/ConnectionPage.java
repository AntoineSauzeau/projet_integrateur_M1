package ui;


import model.Application;
import model.NonSubscriber;
import model.Subscriber;
import sql.Tool.DatabaseConnection;
import sql.dao.SubscriberDAO;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

// import static java.awt.event.MouseEvent.BUTTON1;


//Page de connexion en attente de l'identification du client
public class ConnectionPage extends JPanel {

    JButton buttonNoSub;
    JButton buttonSub;
    ImageIcon iconSub;
    ImageIcon iconNoSub;

    //Faire deux boutons pour log subscriber et log non-subscriber
    public ConnectionPage() {

        this.setLayout(new FlowLayout());

        loadIcons();

        buttonSub = new JButton("Log Sub");
        buttonSub.setIcon(iconSub);
        buttonSub.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonSub.setVerticalTextPosition(SwingConstants.BOTTOM);

        buttonNoSub = new JButton("Log Non-sub");
        buttonNoSub.setIcon(iconNoSub);
        buttonNoSub.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonNoSub.setVerticalTextPosition(SwingConstants.BOTTOM);

        this.add(buttonSub);
        this.add(buttonNoSub);

        setEventHandlers();
    }

    public void loadIcons(){
        try {
            iconSub = new ImageIcon(ImageIO.read(new File("assets/img/log-inIcon.png")));
            iconNoSub = new ImageIcon(ImageIO.read(new File("assets/img/log-inIcon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setEventHandlers(){

        buttonSub.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SubscriberDAO subscriberDAO = null;
                try {
                    subscriberDAO = new SubscriberDAO(DatabaseConnection.getConnection(false));
                } catch (SQLException excep) {
                    excep.printStackTrace();
                }

                Subscriber subscriber = (Subscriber) subscriberDAO.getById(1);

                Application.setNewSubscriber(subscriber);
                Application.getInterface().changePage(InterfacePage.MAIN);
            }
        });
        buttonNoSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.setNewNonSubscriber(new NonSubscriber());
                Application.getInterface().changePage(InterfacePage.MAIN);
            }
        });
    }
}
