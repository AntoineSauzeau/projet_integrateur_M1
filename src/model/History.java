package model;

import java.util.ArrayList;

public class History {
    private ArrayList<Rent> rentalList;


    void updateHistory(Client c){
        //Fait la requete de la base
    }

    public void addRental(Rent rent){
        rentalList.add(rent);
    }

}
