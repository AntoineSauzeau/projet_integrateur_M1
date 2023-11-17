package model;

import java.util.ArrayList;



public class Client {
    protected int id;
    protected boolean isSubscriber;
    protected Integer creditCardNumber;
    protected ArrayList<Rent> rentals;

    public Client(){

    }

    public boolean isSubscriber(){
        return isSubscriber;
    }

    public void SetSubscriber(boolean s){
        isSubscriber = s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Integer creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public ArrayList<Rent> getRentals() {
        return rentals;
    }

    public void setRentals(ArrayList<Rent> rentals) {
        this.rentals = rentals;
    }
}
