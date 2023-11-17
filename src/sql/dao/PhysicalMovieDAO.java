package sql.dao;

import model.Movie;
import model.PhysicalMovie;

import java.sql.Connection;

public class PhysicalMovieDAO extends MovieDAO {

    private Connection connection; // L'objet de connexion à la base de données

    // Constructeur pour injecter la connexion
    public PhysicalMovieDAO(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    public PhysicalMovie getById(int id){
        Movie movie = super.getById(id);
        return (PhysicalMovie) movie;
    }

    public void create(PhysicalMovie m){

    }

    public void delete(PhysicalMovie m){

    }
}

