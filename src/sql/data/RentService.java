package sql.data;

import sql.Tool.Session;
import sql.dao.RentDAO;
import model.Rent;

import java.sql.SQLException;


public class RentService {
    private RentDAO RentDAO;
    private Session session;

    // Constructeur pour injecter la connexion, le DAO et le gestionnaire de transactions
    public RentService(Session session) {
        this.session = session;
    }

    public void addRent(Rent r){
        //Utilise le rentDAO pour ajouter un rent à la base de donnée
        try {
            session.open();
            RentDAO = new RentDAO(session.get());
            RentDAO.addRent(r);
            session.close();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du rent");
        }
        
    }


}
