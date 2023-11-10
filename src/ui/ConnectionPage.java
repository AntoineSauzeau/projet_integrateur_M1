package ui;


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

    //Faire deux boutons pour log subscriber et log non-subscriber
    public ConnectionPage() throws IOException {
        this.setLayout(new FlowLayout());
        JButton buttonSub = new JButton("Log Sub");
        buttonSub.setIcon(new ImageIcon(ImageIO.read(new File("assets/img/log-inIcon.png"))));
        buttonSub.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonSub.setVerticalTextPosition(SwingConstants.BOTTOM);
        final JPanel self = this;
        buttonSub.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                final Container parent = self.getParent();
                parent.removeAll();
                parent.add(new MainPage(1));
                parent.revalidate();
                parent.repaint();
            }
        });

        JButton buttonNoSub = new JButton("Log Non-sub");
        buttonNoSub.setIcon(new ImageIcon(ImageIO.read(new File("assets/img/log-inIcon.png"))));
        buttonNoSub.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonNoSub.setVerticalTextPosition(SwingConstants.BOTTOM);

        buttonNoSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final Container parent = self.getParent();
                parent.removeAll();
                parent.add(new MainPage(0)); //
                parent.revalidate();
                parent.repaint();
            }
        });

        this.add(buttonSub);
        this.add(buttonNoSub);

    }
}
