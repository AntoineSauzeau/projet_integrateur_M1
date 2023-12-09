package model;


import java.sql.Date;

public class Subscriber extends Client {

    private Integer id;
    private String name;
    private String address;
    private String mail;
    private Date birthdate;
    private Integer subCardNumber;
    private Integer creditCardNumber;


    private Float balance;

    //TODO faire des getter et setter avec des clones si on est propre

    public Subscriber(){
        isSubscriber = true;
    }

    public void addRent(Rent r){
        //TODO
        return;
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

        this.balance += credit;
        return true;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSubCardNumber() {
        return subCardNumber;
    }

    public void setSubCardNumber(Integer subCardNumber) {
        this.subCardNumber = subCardNumber;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Integer creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
