package model;

import java.util.Date;

public class Rent {

    Date rentDate;
    Date returnDate;
    boolean paid;
    double cost;


    public Rent(){

    }

    // SETTERS - GETTERS ================================================================================

    public void setRentDate(Date rentDate){
        this.rentDate = rentDate;
    }

    public void setReturnDate(Date returnDate){
        this.returnDate = returnDate;
    }

    public void setPaid(boolean paid){
        this.paid = paid;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public Date getRentDate(){
        return rentDate;
    }

    public Date getReturnDate(){
        return returnDate;
    }

    public boolean getPaid(){
        return paid;
    }

    public double getCost(){
        return cost;
    }

    // ====================================================================================================
}
