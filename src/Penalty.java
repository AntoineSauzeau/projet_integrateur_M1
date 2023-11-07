
import java.util.Date;

public class Penalty {

    private double amountPaid;
    private Date penaltyStartDate;
    private Date penaltyEndDate;
    private Rent rent;

    public Penalty(Rent rent){
        this.rent = rent;
    }
}
