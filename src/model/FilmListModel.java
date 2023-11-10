package model;

import java.util.List;

import listener.ListChangeListener;

public class FilmListModel {

    List<Movie> lMovies;
    List<ListChangeListener> lListener;

    public void add(Movie movie){
        lMovies.add(movie);
        notifyChange();
    }

    public void notifyChange(){
        for(int i = 0; i < lListener.size(); i++){
            lListener.get(i).listChanged();
        }
    }

    public void addListener(ListChangeListener l){
        lListener.add(l);
    }
}