package Data;

import Business.Scene;
import View.VerifyData;
import View.VerifyDataException;
import View.groupe.GroupeNotAcceptedException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ComboBoxModel;

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

    public Vector<String> getAllLibScene() throws BDException {
        Connection connex;
        ResultSet result;
        Vector<String> vec = new Vector<String>();

        try {
            connex = ConnexBD.getInstance();
            Statement stat = connex.createStatement();
            String sel = "SELECT scene.Nom FROM scene ORDER BY scene.Nom;";
            result = stat.executeQuery(sel);
            while(result.next()) {
                vec.add(result.getString("Nom"));
            }

        } catch (SQLException e) {
            throw new BDException(e);
        } catch (LoginException e) {
            throw new BDException(e);
        } finally {
            return vec;
        }
    }
}

