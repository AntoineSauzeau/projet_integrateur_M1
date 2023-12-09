package Controler;

import java.util.concurrent.ExecutionException;

import javax.swing.*;

import ui.AccountPage;
import ui.ConnectionPage;
import ui.MainPage;


public class CreatorThread extends SwingWorker<JPanel, Void> {

    enum CreatorThreadType {
        MAIN_PAGE,
        MOVIE_PAGE,
        ACCOUNT_PAGE,
        CONNECTION_PAGE
    }

    enum VarType {
        MAIN,
        PREC
    }

    CreatorThreadType type_t;
    VarType var_t;

    public CreatorThread(String var, String type) {
        switch (type) {
            case "MAIN_PAGE":
                type_t = CreatorThreadType.MAIN_PAGE;
                break;
            case "MOVIE_PAGE":
                type_t = CreatorThreadType.MOVIE_PAGE;
                break;
            case "ACCOUNT_PAGE":
                type_t = CreatorThreadType.ACCOUNT_PAGE;
                break;
            case "CONNECTION_PAGE":
                type_t = CreatorThreadType.CONNECTION_PAGE;
                break;
            default:
                break;
        }
        switch (var) {
            case "MAIN":
                var_t = VarType.MAIN;
                break;
            case "PREC":
                var_t = VarType.PREC;
                break;
        }
    }

    @Override
    protected JPanel doInBackground() {
        switch (type_t) {
            case MAIN_PAGE:
                return new MainPage();
            case ACCOUNT_PAGE:
                return new AccountPage();
            case CONNECTION_PAGE:
                return new ConnectionPage();
            default:
                return null;
        }
    }

    @Override
    protected void done() {
        try {
            JPanel panel = get();
            if (var_t == VarType.MAIN)
                Controler.getInstance().chargeMain(panel);
            else if (var_t == VarType.PREC)
                Controler.getInstance().changePrec(panel);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}