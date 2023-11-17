package sql.dao;

import model.Movie;
import model.Rent;
import sql.Tool.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;

public class RentDAO {

    private Connection connection;

    public RentDAO(Connection connection){
        this.connection = connection;
    }

    public Rent getById(int movieID, int clientID){
        Rent rent = null;

        String sql = "SELECT withdrawalDate, paid, type, returnDate FROM Rents WHERE clientID=? AND movieID=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, clientID);
            statement.setInt(2, movieID);
            ResultSet result = statement.executeQuery();
            if (result.first()) {
                rent = new Rent();
                rent.setRentDate(result.getDate("withdrawalDate"));
                rent.setPaid(result.getBoolean("paid"));
                rent.setType(result.getInt("type"));
                rent.setReturnDate(result.getDate("returnDate"));

                MovieDAO movieDAO = new MovieDAO(DatabaseConnection.getConnection(true));
                rent.setMovie(movieDAO.getById(movieID));

                ClientDAO clientDAO = new ClientDAO(DatabaseConnection.getConnection(true));
                rent.setClient(clientDAO.getById(clientID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rent;
    }

    public ArrayList<Rent> getClientRents(int clientId){
        ArrayList<Rent> rents = new ArrayList<Rent>();

        String sql = "SELECT withdrawalDate, paid, type, returnDate FROM Rents WHERE clientID=?";

        return rents;
    }

}
