import java.util.ArrayList;

public class MovieRack {

    public ArrayList<Movie> rack;
    public int nb_bluray;


    public Boolean isFull(){
        return rack.size() == 100;
    }

}
