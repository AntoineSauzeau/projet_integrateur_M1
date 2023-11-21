package tests;

import model.Subscriber;
import sql.Tool.DatabaseConnection;
import sql.Tool.Session;
import sql.dao.SubscriberDAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class TestSQL {
    public static void main(String[] args) throws SQLException {
        setUp();


        // Créez une connexion à votre base de données (par exemple, MySQL)
        Session session = new Session(true);
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

    public static void setUp() throws SQLException {
        // Créez un gestionnaire de transactions pour les tests
        Session session = new Session(true);
        try {
            session.open();
            // Créez une déclaration SQL pour exécuter des requêtes SQL
            Statement statement = session.get().createStatement();

            // Exécutez un script SQL pour créer Toutes les tables
            //String createTableSQL = "CREATE TABLE Utilisateur (id INT PRIMARY KEY, nom VARCHAR(255), prenom VARCHAR(255))";
            //statement.execute(createTableSQL);


            BufferedReader reader = new BufferedReader(new FileReader("src/sql/table.sql"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            // Exécuter le script SQL
            String createTableSQL = stringBuilder.toString();
            statement.execute(createTableSQL);

            // Ajoutez des données initiales si nécessaire
            // String insertDataSQL = "INSERT INTO Utilisateur (id, nom, prenom) VALUES (1, 'Smith', 'Joe')";
            // statement.execute(insertDataSQL);

            // Fermez la connexion et la déclaration
            statement.close();
            session.close();
        } catch (SQLException e) {
            session.rollback();
            session.close();
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
