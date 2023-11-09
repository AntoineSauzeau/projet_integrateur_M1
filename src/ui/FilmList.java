package ui;

import listener.ListChangeListener;
import model.FilmListModel;

import javax.swing.*;

public class FilmList extends JPanel implements ListChangeListener {

    FilmListModel filmListModel;

    public FilmList(FilmListModel filmListModel){
        this.filmListModel = filmListModel;
        filmListModel.addListener(this);
    }

    public void update(){

    }

    @Override
    public void listChanged() {
        update();
    }
}
