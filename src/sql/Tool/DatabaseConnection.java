package sql.Tool;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL_Runtime = "jdbc:oracle:thin:@im2ag-oracle.univ-grenoble-alpes.fr:1521:im2ag";
    private static final String USER_Runtime = "jouanotf";
    private static final String PASSWORD_Runtime = "c976d43602";

    public static Connection getConnection(boolean mode) throws SQLException {
        /*if (mode) {
            return DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        } else {
            try {
                // Charger le driver JDBC Oracle
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new SQLException("Le pilote JDBC Oracle n'a pas pu être chargé.");
            }

            // Retourner la connexion à la base de données Oracle
            return DriverManager.getConnection(URL_Runtime, USER_Runtime, PASSWORD_Runtime);
        }*/
        return DriverManager.getConnection("jdbc:sqlite:src/sql/database.db");
    }

}