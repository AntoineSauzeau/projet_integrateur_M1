
import ui.Interface;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Interface();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


}