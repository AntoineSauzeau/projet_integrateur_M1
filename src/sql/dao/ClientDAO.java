package sql.dao;

import model.Client;
import model.History;
import model.Movie;
import model.Rent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {
    private Connection connection;

    public ClientDAO(Connection connection){
        this.connection = connection;
    }

    public Client getById(int id){
        Client client = null;

        String sql = "SELECT creditCard FROM Clients WHERE clientID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            client = new Client();
            client.setCreditCardNumber(result.getInt("creditCard"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return client;
    }

    //TODO Implementer getHistory, pas besoin de rent.setClient(); ?
    public History getHistory(int id){
        History history = new History();

        String sql = "SELECT * FROM History h JOIN Movie m USING(idMovie) WHERE clientID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Movie movie = new Movie();
                movie.setName(result.getString("movieName"));

                Rent rent = new Rent();
                //rent.setClient();
                rent.setMovie(movie);
                rent.setRentDate(result.getDate("withdrawalDate"));
                //rent.setCost();
                rent.setPaid(result.getBoolean("paid"));
                rent.setType(result.getInt("type"));
                rent.setReturnDate(result.getDate("returnDate"));

                history.addRental(rent);
            }
            return history;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
