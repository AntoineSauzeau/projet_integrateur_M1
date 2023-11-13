package model;

import java.util.ArrayList;



public abstract class Client {
    boolean isSubscriber;
    Integer creditCardNumber;

    ArrayList<Rent> rentals;

    public Client(){

    }

    public boolean isSubscriber(){
        return isSubscriber;
    }

    public void SetSubscriber(boolean s){
        isSubscriber = s;
    }
}
