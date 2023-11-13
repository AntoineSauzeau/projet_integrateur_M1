package model;

import ui.Interface;

public class Application {
    private static Client client;
    private static Interface ui;

    public static Client getClientConnected(){
        return client;
    }

    public static void setNewConnectedClient(Client c){
        client = c;
    }

    public static Interface getInterface(){
        return ui;
    }

    public static void setNewInterface(Interface ui_){
        ui = ui_;
    }
}
