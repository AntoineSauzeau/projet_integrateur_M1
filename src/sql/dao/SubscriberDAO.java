package sql.dao;

import model.Subscriber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriberDAO extends ClientDAO{

    private Connection connection; // L'objet de connexion à la base de données

    // Constructeur pour injecter la connexion
    public SubscriberDAO(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    public void create(Subscriber c){
        String sql = "INSERT INTO suscribers (name, idClient, creditCard, address, birthDate, mail, balance, subCardId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement req = connection.prepareStatement(sql);
            req.setString(1, c.getName());
            req.setInt(2, c.getId());
            req.setInt(3, c.getCreditCardNumber());
            req.setString(4, c.getAddress());
            req.setDate(5, c.getBirthdate());
            req.setString(6, c.getMail());
            req.setFloat(7, c.getBalance());
            req.setInt(8, c.getSubCardNumber());
            req.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Subscriber getById(int id){

        Subscriber sub = (Subscriber) super.getById(id);

        String sql = "SELECT * FROM Subscribers WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.first()){

                sub.setId(id);
                sub.setName(result.getString("name"));
                sub.setBalance(result.getFloat("balance"));
                sub.setSubCardNumber(result.getInt("subCardId"));
                sub.setBirthdate(result.getDate("birthdate"));
                sub.setMail(result.getString("mail"));
                sub.setAddress(result.getString("address"));

                return sub;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Subscriber sub){

        String sql = "UPDATE Subscriber SET name = ?, clientID = ?, address = ?, birthDate = ?, mail = ?, balance = ?, subCardID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, sub.getName());
            statement.setInt(2, sub.getId());
            statement.setString(3, sub.getAddress());
            statement.setDate(4, sub.getBirthdate());
            statement.setString(5, sub.getMail());
            statement.setFloat(6, sub.getBalance());
            statement.setInt(7, sub.getSubCardNumber());

            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Clients WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

}
