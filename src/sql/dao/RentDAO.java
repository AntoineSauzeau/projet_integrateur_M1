package sql.dao;

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

    public int addRent(Rent r){
        String sql = "INSERT INTO Rents (withdrawalDate, paid, type, returnDate, clientID, movieID) VALUES (?, ?, ?, ?, ?, ?)";

        // Insertion du rent dans la base de données
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(r.getRentDate().getTime()));
            statement.setBoolean(2, false);
            statement.setInt(3, 0);
            statement.setDate(4, new Date(0));
            statement.setInt(5, 2);
            statement.setInt(6, r.getMovie().getId());
            statement.executeUpdate();

            System.out.println("Rent added");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return -1;
    }

}
