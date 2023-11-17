package model;

import java.util.ArrayList;

public class Movie {
    protected String title;
    protected Integer id;
    protected String category;
    protected String summary;
    protected String director;
    protected ArrayList<String> mainActors ;



    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<String> getMainActors() {
        return (ArrayList<String>) mainActors.clone();
    }

    public void setMainActors(ArrayList<String> mainActors) {
        this.mainActors = mainActors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
