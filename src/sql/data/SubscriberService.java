package sql.data;

import model.Rent;
import model.Subscriber;
import sql.Tool.Session;
import sql.dao.ClientDAO;
import sql.dao.RentDAO;

import java.sql.SQLException;

public class SubscriberService {
    private ClientDAO clientDAO;


    private Session session;

    // Constructeur pour injecter la connexion, le DAO et le gestionnaire de transactions
    public SubscriberService(Session session) {
        this.session = session;
    }

    public void addChangeSold(Subscriber s,Float change) {
        //Utilise le rentDAO pour ajouter un rent à la base de donnée
        try {
            session.open();
            clientDAO = new ClientDAO(session.get());
            clientDAO.changeSold(s, change);
            session.close();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du changement de solde dans la bd");
        }

    }


}
