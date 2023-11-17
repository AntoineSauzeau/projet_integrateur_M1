package tests;

import model.Subscriber;
import sql.Tool.DatabaseConnection;
import sql.Tool.Session;
import sql.dao.SubscriberDAO;

import java.sql.Connection;
import java.sql.SQLException;


public class TestSQL {
    public static void main(String[] args) throws SQLException {
        // Créez une connexion à votre base de données (par exemple, MySQL)
        Session session = new Session(false);
        //DatabaseConnection dataConn = new DatabaseConnection();
        Connection conn = DatabaseConnection.getConnection(false);

        // Créez un gestionnaire de transactions

        // Créez un service avec le DAO et le gestionnaire de transactions
        SubscriberDAO subscriberService = new SubscriberDAO(conn);

        // Exemple d'utilisation du service
        Subscriber newSubscriber = new Subscriber();
        subscriberService.create(newSubscriber);

        //Subscriber utilisateurRecupere = subscriberService.getUserById(1);
        //System.out.println("Utilisateur récupéré : " + utilisateurRecupere);


    }
}
