package model;

import java.util.ArrayList;



public abstract class Client {
    boolean isSuscriber;
    Integer creditCardNumber;

    ArrayList<Rent> rentals;

    public Client(){

    }

    public boolean isSubscriber(){
        return isSuscriber;
    }

    public void SetSubscriber(boolean s){
        isSuscriber = s;
    }
}
