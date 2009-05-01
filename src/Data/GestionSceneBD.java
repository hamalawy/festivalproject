package Data;

import View.VerifyData;
import View.VerifyDataException;
import View.groupe.GroupeNotAcceptedException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionSceneBD {

    private String ajout;
    private Object String;

    public void createScene(Scene newScene) throws BDException, LoginException, GroupeNotAcceptedException {
        Connection connex;

        try {
            connex = ConnexBD.getInstance();
            Statement stat = connex.createStatement();
            String ajout = "INSERT INTO scene (nom,capaciteMax,superficie,nbIngenieur,description) VALUES " + "('" + newScene.getNom() + "','" + newScene.getCapaciteMax() + "','" + newScene.getSuperficie() + "','" + newScene.getNbIngenieur() + "','" + newScene.getDescription() + "');";
            int nbIns = stat.executeUpdate(ajout);

        } catch (SQLException e) {
            throw new BDException(e);
        }
    }
}

