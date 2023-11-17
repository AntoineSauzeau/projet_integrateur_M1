package sql.dao;

import model.Client;

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
            if (result.first()) {
                client = new Client();
                client.setCreditCardNumber(result.getInt("creditCard"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return client;
    }
}
