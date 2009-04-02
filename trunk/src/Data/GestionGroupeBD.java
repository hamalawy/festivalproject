/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;
import java.util.Vector;


/**
 *
 * @author Cramike
 */
public class GestionGroupeBD {

    private String ajout;
    private Object String;

    public void createGroupe(Groupe newGroupe, Vector<MembreGroupe> vectMembre) throws BDException, LoginException {
        // TODO Auto-generated method stub
        Connection connex;
        try {
            connex = ConnexBD.getInstance();
            Statement stat = connex.createStatement();
            if (newGroupe.getSiteWeb().isEmpty()) {
                ajout = "INSERT INTO groupe (Nom, Nationalite, GenreMusical, Cout, Popularite) VALUES " + "('" + newGroupe.getNom() + "','" + newGroupe.getNationalite() + "','" + newGroupe.getGenre() + "','" + newGroupe.getCout() + "','" + newGroupe.getPopularite() + "');";
            } else {
                ajout = "INSERT INTO groupe (Nom, Nationalite, GenreMusical, Cout, Popularite, SiteWeb) VALUES " + "('" + newGroupe.getNom() + "','" + newGroupe.getNationalite() + "','" + newGroupe.getGenre() + "','" + newGroupe.getCout() + "','" + newGroupe.getPopularite() + "','" + newGroupe.getSiteWeb() + "');";
            }
            int nbLigne = stat.executeUpdate(ajout);

        //Ajout des membres du groupe
        stat = connex.createStatement();
        


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new BDException(e);
        }

    }

    public void deleteMembreGroupe(MembreGroupe membre) {
        Connection connex;
        Statement stat;
        //String supprMembre = "DELETE "
    }

    public Vector<String> getAllGenre() throws BDException, LoginException{
        try {
            Connection connex;
            Statement stat;
            ResultSet result;
            Vector<String> vectGenre = new Vector<String>();
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();
            ajout = "SELECT DISTINCT groupe.GenreMusical" + " " + "FROM groupe" + " " + "ORDER BY groupe.GenreMusical;";
            result = stat.executeQuery(ajout);
            while (result.next()) {
                vectGenre.add(result.getString("GenreMusical"));
            }
            return vectGenre;
        } catch (SQLException ex) {
            throw new BDException(ex);
        }
    }

    public Vector<String> getAllGroupeNationalite() throws BDException, LoginException {
        Connection connex;
        Statement stat;
        ResultSet result;
        Vector<String> vect = new Vector<String>();
        try {
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();

            ajout = "SELECT DISTINCT groupe.Nationalite" + " " +
                    "FROM groupe" + " " +
                    "ORDER BY groupe.Nationalite;";

            result = stat.executeQuery(ajout);
            while (result.next()) {
                vect.add(result.getString("Nationalite"));
            }
        } catch (SQLException e) {
            throw new BDException(e);
        } finally {
            return vect;
        }
    }

    public Vector<MembreGroupe> getAllMembreGroupe() throws BDException, LoginException {

        Connection connex;
        Statement stat;
        ResultSet result;
        Vector<MembreGroupe> vect = new Vector<MembreGroupe>();

        try {
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();

            ajout = "SELECT Nom,Prenom,Nationalite,DateNaiss,Domaine,Instrument " + " " +
                    "FROM membre_groupe" +
                    "ORDER BY ASC" + ";";


            result = stat.executeQuery(ajout);
            System.out.println(result);
            while (result.next()) {
                MembreGroupe temp = new MembreGroupe(
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getString("Pseudo"),
                        result.getString("Nationalite"),
                        result.getString("Domaine"),
                        result.getString("Instrument"),
                        result.getDate("DateNaiss"));
                vect.add(temp);

            }
            return vect;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new BDException(e);

        }

    }

    public Vector<String> getAllMembreGroupeNationalite() throws BDException, LoginException {
        Connection connex;
        Statement stat;
        ResultSet result;
        Vector<String> vect = new Vector<String>();
        try {
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();

            ajout = "SELECT DISTINCT membre_groupe.Nationalite" + " " +
                    "FROM membre_groupe" + " " +
                    "ORDER BY membre_groupe.Nationalite;";

            result = stat.executeQuery(ajout);
            while (result.next()) {
                vect.add(result.getString("Nationalite"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new BDException(e);

        } finally {
            return vect;
        }

      

    }
}
