import java.util.ArrayList;

public class Search {

    EnumTypeSearch keywordType;

    String keyword;

    public enum EnumTypeSearch {
        ACTOR, DIRECTOR, MOVIE_NAME, UNKNOWN 
    }

    public Search(String keyword, EnumTypeSearch keywordType) {
        this.keyword = keyword;
        this.keywordType = keywordType;
    }

    // Méthode pour la recherche : à voir si on conserve la classe entière
    public ArrayList<Movie> search(ArrayList<Movie> movies) {
        ArrayList<Movie> result = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.getMainActors().contains(keyword)) {
                result.add(movie);
            }
            else if (movie.getDirector().equals(keyword)) {
                result.add(movie);
            }
            else if (movie.getName().equals(keyword)) {
                result.add(movie);
            }
        }
        return result;
    }



}
