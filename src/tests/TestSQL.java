package tests;

import model.Subscriber;
import sql.Tool.DatabaseConnection;
import sql.Tool.Session;
import sql.dao.SubscriberDAO;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class TestSQL {

    static Connection conn;

    static {
        try {
            conn = DatabaseConnection.getConnection(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TestSQL() throws SQLException {
    }

    public static void main(String[] args) throws Exception {
        setUp();



        // Créez une connexion à votre base de données (par exemple, MySQL)
        Session session = new Session(true);

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
            String sqlScript = loadSqlScript("src/sql/tables.sql");
            // Créez une déclaration SQL pour exécuter des requêtes SQL
            Statement statement = session.get().createStatement();

            statement.execute(sqlScript);

            /*
            BufferedReader reader = new BufferedReader(new FileReader("src/sql/tables.sql"));

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            // Exécuter le script SQL
            String createTableSQL = stringBuilder.toString();
            statement.execute(createTableSQL);

            // Ajoutez des données initiales si nécessaire
            reader = new BufferedReader(new FileReader("src/sql/data.sql"));
            stringBuilder = new StringBuilder();
            String line2;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String insertDataSQL = stringBuilder.toString();
            statement.execute(insertDataSQL);*/

            // Fermez la connexion et la déclaration
            statement.close();
            session.close();
        } catch (SQLException e) {
            session.rollback();
            session.close();
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static String loadSqlScript(String filePath) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }

        return stringBuilder.toString();
    }



}
