package model;

import ui.Interface;

public class Application {
    private static Subscriber subscriber;
    private static NonSubscriber nonSubscriber;
    private static boolean isSubscriber;
    private static Interface ui;

    public static boolean clientIsSubscriber(){
        return isSubscriber;
    }

    public static Subscriber getSubcriberConnected(){
        return subscriber;
    }

    public static NonSubscriber getNonSubscriberConnected(){
        return nonSubscriber;
    }

    public static void setNewSubscriber(Subscriber c){
        subscriber = c;
        isSubscriber = true;
    }

    public static void setNewNonSubscriber(NonSubscriber c){
        nonSubscriber = c;
        isSubscriber = false;
    }

    public static Interface getInterface(){
        return ui;
    }

    public static void setNewInterface(Interface ui_){
        ui = ui_;
    }
}
