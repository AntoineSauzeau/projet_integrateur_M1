
import model.Application;
import ui.Interface;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Interface ui = new Interface();
                Application.setNewInterface(ui);
                ui.show();
            }
        });
    }


}