package model;


public class Subscriber extends Client {

    private String name;
    private Integer subCardNumber;
    private Double credit;
    //TODO faire des getter et setter avec des clones si on est propre

    public Subscriber(){
        isSubscriber = true;
    }

    public void getInformation(){
        //TODO
        return;
    }

    public boolean refund(double qt){
        //TODO Remplis le crédit de qt, return un true false si ça a fonctionné,  10€ min
        return true;
    }

    public void fidelityGift(){
        //TODO Donne du crédit si le client a loué X films dans le mois (une fois par mois max)
    }

    public Boolean addCredit(int credit){
        if(credit < 10) return false;

        this.credit += credit;
        return true;
    }

}
