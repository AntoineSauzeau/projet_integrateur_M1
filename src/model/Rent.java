package model;

import java.util.Date;

public class Rent {

    private Date rentDate;
    private Date returnDate;
    private boolean paid;
    private double cost;
    private int type;
    private Client client;
    private Movie movie;
    private Penalty penalty;

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

    public int getIType() {
        return type;
    }

    public RentType getType(){
        if(type == 0)
            return RentType.BLURAY;
        return RentType.QRCODE;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    // ====================================================================================================
}
