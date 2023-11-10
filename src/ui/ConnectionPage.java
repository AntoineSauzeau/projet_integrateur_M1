package ui;


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import static java.awt.event.MouseEvent.BUTTON1;


//Page de connexion en attente de l'identification du client
public class ConnectionPage extends JPanel {

    //Faire deux boutons pour log subscriber et log non-subscriber
    public ConnectionPage(){
        this.setLayout(new BorderLayout());
        JButton buttonSub = new JButton("Log Sub");

        final JPanel self = this;
        buttonSub.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final Container parent = self.getParent();
                parent.removeAll();
                parent.add(new MainPage(1)); //
            }
        });

        JButton buttonNoSub = new JButton("Log Non-sub");

        buttonNoSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final Container parent = self.getParent();
                parent.removeAll();
                parent.add(new MainPage(0)); //
            }
        });

    }
}
