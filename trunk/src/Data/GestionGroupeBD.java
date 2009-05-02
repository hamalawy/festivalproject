/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.MembreGroupe;
import Business.GroupeID;
import Business.Groupe;
import Business.GroupeScene;
import Business.MembreGroupeAgrandi;
import View.VerifyData;
import View.VerifyDataException;
import Data.CriteresRecherche;
import View.groupe.GroupeNotAcceptedException;
import View.groupe.InscrGroupePanel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cramike
 */
public class GestionGroupeBD {

    private String ajout;
    private Object String;

    public void addMembreToGroupe(GroupeID groupe, MembreGroupe m) throws BDException, GroupeNotAcceptedException, LoginException {
        Connection connex;
        VerifyData v = new VerifyData();
        try {
            connex = ConnexBD.getInstance();
            Statement stat = connex.createStatement();
            ResultSet result;

            stat = connex.createStatement();
            ajout = "INSERT INTO membre_groupe( Nom, Prenom, Pseudo, Nationalite, Domaine, DateNaiss, FKNomGroupe, FKNationaliteGroupe, Instrument ) VALUES " +
                    "('" + v.getSQLString(m.getNom()) + "','" + v.getSQLString(m.getPrenom()) + "','" + v.getSQLString(m.getSurnom()) + "','" + v.getSQLString(m.getNationalite()) +
                    "','" + m.getDomaine() + "',#" + m.getDateNaiss().toString() + "#,'" + v.getSQLString(groupe.getNom()) + "','" + v.getSQLString(groupe.getNationalite()) +
                    "','" + ((m.getInstrument() != null) ? v.getSQLString(m.getInstrument()) : "") + "');";
            stat.executeUpdate(ajout);

        } catch (SQLException e) {
            throw new BDException(e);
        } catch (VerifyDataException e) {
            throw new GroupeNotAcceptedException(e);
        }
    }

    public void createGroupe(Groupe newGroupe) throws BDException, LoginException, GroupeNotAcceptedException {
        // TODO Auto-generated method stub
        Connection connex;
        VerifyData v = new VerifyData();
        try {
            connex = ConnexBD.getInstance();
            Statement stat = connex.createStatement();
            String cout = v.getSQLDoubleString(newGroupe.getCout(), true);
            if (newGroupe.getSiteWeb().isEmpty()) {
                ajout = "INSERT INTO groupe (Nom, Nationalite, GenreMusical, Cout, Popularite) VALUES " + "('" + v.getSQLString(newGroupe.getNom()) + "','" + v.getSQLString(newGroupe.getNationalite()) + "','" + v.getSQLString(newGroupe.getGenre()) + "','" + cout + "','" + newGroupe.getPopularite() + "');";
            } else {
                ajout = "INSERT INTO groupe (Nom, Nationalite, GenreMusical, Cout, Popularite, SiteWeb) VALUES " + "('" + v.getSQLString(newGroupe.getNom()) + "','" + v.getSQLString(newGroupe.getNationalite()) + "','" + v.getSQLString(newGroupe.getGenre()) + "','" + cout + "','" + newGroupe.getPopularite() + "','" + v.getSQLString(newGroupe.getSiteWeb()) + "');";
            }
            int nbLigne = stat.executeUpdate(ajout);

            //Ajout des membres du groupe

            if (newGroupe.getVecMembres() != null) {
                for (MembreGroupe m : newGroupe.getVecMembres()) {

                    stat = connex.createStatement();
                    ResultSet result;


                    stat = connex.createStatement();
                    ajout = "INSERT INTO membre_groupe ( Nom, Prenom, Pseudo, Nationalite, Domaine, DateNaiss, FKNomGroupe, FKNationaliteGroupe, Instrument ) VALUES " +
                            "('" + v.getSQLString(m.getNom()) + "','" + v.getSQLString(m.getPrenom()) + "','" + v.getSQLString(m.getSurnom()) + "','" + v.getSQLString(m.getNationalite()) +
                            "','" + m.getDomaine() + "',#" + m.getDateNaiss().toString() + "#,'" + v.getSQLString(newGroupe.getNom()) + "','" + v.getSQLString(newGroupe.getNationalite()) +
                            "','" + ((m.getInstrument() != null) ? v.getSQLString(m.getInstrument()) : "") + "');";
                    stat.executeUpdate(ajout);
                }
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(ajout);
            throw new BDException(e);
        } catch (VerifyDataException e) {
            throw new GroupeNotAcceptedException(e);
        }


    }

    public void deleteGroupe(GroupeID groupe) throws BDException {
        try {
            Connection connex;
            Statement stat;
            String supprGroupe = "DELETE * FROM groupe WHERE groupe.Nom = '" + groupe.getNom() + "' AND groupe.Nationalite = '" + groupe.getNationalite() + "';";
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();
            int nbLignesSuppr = stat.executeUpdate(supprGroupe);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new BDException(new SuppressionException(ex));
        } catch (LoginException ex) {
            throw new BDException(ex);
        }
    }

    public Vector<GroupeID> getAllGroupeForList() throws BDException, LoginException {
        Connection connex;
        Statement stat;
        ResultSet result;
        Vector<GroupeID> vect = new Vector<GroupeID>();
        try {
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();

            ajout = "SELECT groupe.Nationalite, groupe.Nom" + " " +
                    "FROM groupe" + " " +
                    "ORDER BY groupe.Nom;";

            result = stat.executeQuery(ajout);
            while (result.next()) {
                vect.add(new GroupeID(result.getString("Nom"), result.getString("Nationalite")));
            }
        } catch (SQLException e) {
            throw new BDException(e);
        } finally {
            return vect;
        }

    }

    public void deleteMembreGroupe(MembreGroupe membre, GroupeID groupe) throws BDException {
        try {
            Connection connex;
            Statement stat;
            String supprMembre = "DELETE * FROM membre_groupe WHERE membre_groupe.Nom = '" + membre.getNom() + "' AND membre_groupe.Prenom = '" + membre.getPrenom() + "' AND membre_groupe.FKNomGroupe = '" + groupe.getNom() + "' AND membre_groupe.FKNationaliteGroupe = '" + groupe.getNationalite() + "';";
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();
            int nbLignesSuppr = stat.executeUpdate(supprMembre);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new BDException(new SuppressionException(ex));
        } catch (LoginException ex) {
            throw new BDException(ex);
        }
    }

    public Vector<String> getAllGenre() throws BDException {
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
        } catch (LoginException ex) {
            throw new BDException(ex);
        }
    }

    public Vector<GroupeScene> getAllGroupeGenreByScene(String scene) throws BDException {
        Connection connex;
        Statement stat;
        ResultSet result;
        Vector<GroupeScene> vect = new Vector<GroupeScene>();

        try {
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();
            String req = "SELECT groupe.Nom, groupe.Nationalite, groupe.GenreMusical, scene.Nom FROM groupe, scene WHERE groupe.FKScene = scene.Numero " +
                    "AND scene.Nom = '" + scene + "';";
            System.out.println(req);
            result = stat.executeQuery(req);
            while (result.next()) {
                vect.add(new GroupeScene(result.getString(1), result.getString(2), result.getString(4), result.getString(3)));
            }
        } catch (SQLException e) {
            throw new BDException(e);
        } finally {
            return vect;
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

    public Vector<GroupeScene> getAllGroupeGenre(String genre) throws BDException {
        Connection connex;
        Statement stat;
        ResultSet result;
        Vector<GroupeScene> vect = new Vector<GroupeScene>();

        try {
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();
            String req = "SELECT groupe.Nom, groupe.Nationalite, scene.Nom FROM groupe, scene WHERE (groupe.FKScene = scene.Numero) " +
                    "AND groupe.GenreMusical = '" + genre + "';";
            System.out.println(req);
            result = stat.executeQuery(req);
            while (result.next()) {
                System.out.println("getAllGroupeScene");
                vect.add(new GroupeScene(result.getString(1), result.getString(2), result.getString(3), genre));
            }

            //On rajoute les groupes sans scènes
            stat = connex.createStatement();
            String req2 = "SELECT groupe.Nom, groupe.Nationalite FROM groupe WHERE ((groupe.FKScene) Is Null) " +
                    "AND groupe.GenreMusical = '" + genre + "';";
            System.out.println(req2);
            result = stat.executeQuery(req2);
            while (result.next()) {
                System.out.println("getAllGroupeScene2");
                vect.add(new GroupeScene(result.getString(1), result.getString(2), "", genre));
            }

        } catch (SQLException e) {
            throw new BDException(e);
        } finally {
            return vect;
        }
    }

    public Vector<GroupeScene> getAllGroupeNoScene() throws BDException {
        Connection connex;
        Statement stat;
        ResultSet result;
        Vector<GroupeScene> vect = new Vector<GroupeScene>();

        try {
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();
            String req = "SELECT  groupe.Nom, groupe.Nationalite, groupe.GenreMusical FROM groupe " + "WHERE ((groupe.FKScene)Is Null);";
            System.out.println("tableGroupe : " + req);
            result = stat.executeQuery(req);
            while (result.next()) {
                vect.add(new GroupeScene(result.getString(1), result.getString(2), null, result.getString(3)));
            }
        } catch (SQLException e) {
            throw new BDException(e);
        } finally {
            return vect;
        }
    }

    public Vector<String> getAllInstrument() throws BDException, LoginException {

        Connection connex;
        Statement stat;
        ResultSet result;
        Vector<String> vect = new Vector<String>();

        try {
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();
            String req = "SELECT DISTINCT Instrument FROM membre_groupe;";
            result = stat.executeQuery(req);
            while (result.next()) {
                vect.add(result.getString("Instrument"));
            }
        } catch (SQLException e) {
            throw new BDException(e);
        } finally {
            return vect;
        }
    }

    public Vector<MembreGroupe> getAllMembreGroupe(GroupeID groupeSelected) throws BDException, LoginException {

        Connection connex;
        Statement stat;
        ResultSet result;
        Vector<MembreGroupe> vect = new Vector<MembreGroupe>();

        try {
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();

            ajout = "SELECT membre_groupe.* " + " " +
                    "FROM membre_groupe " +
                    "WHERE FKNomGroupe = '" + groupeSelected.getNom() + "' " +
                    "AND FKNationaliteGroupe = '" + groupeSelected.getNationalite() + "';";


            result = stat.executeQuery(ajout);
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
            throw new BDException(e);

        } finally {
            return vect;
        }
    }

    public Vector<MembreGroupeAgrandi> getAllResultMembre(CriteresRecherche c) throws BDException {
        Vector<MembreGroupeAgrandi> vec = new Vector<MembreGroupeAgrandi>();
        try {
            Connection connex;
            Statement stat;
            ResultSet result;

            connex = ConnexBD.getInstance();
            stat = connex.createStatement();

            //Création de la requête
            RequeteMembreSearch r = new RequeteMembreSearch();
            String requete = r.getRequete(c);
            System.out.println(requete);
            result = stat.executeQuery(requete);

            while (result.next()) {
                MembreGroupeAgrandi m = new MembreGroupeAgrandi();

                m.setNom(result.getString(1));
                m.setPrenom(result.getString(2));
                m.setDateNaiss(result.getDate(8));
                m.setDomaine(result.getString(7));
                m.setInstrument(result.getString(9));
                m.setNationalite(result.getString(6));
                m.setSurnom(result.getString(5));
                m.setGenre(result.getString(12));
                m.setNationaliteGroupe(result.getString(11));
                m.setNomGroupe(result.getString(10));

                vec.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new BDException(e);
        } catch (VerifyDataException e) {
            throw new BDException(e);
        } finally {
            return vec;
        }
    }

    public Groupe getGroupeSelected(GroupeID groupeSelected) throws BDException, LoginException {
        Connection connex;
        Statement stat;
        ResultSet result;
        Groupe groupe = new Groupe();
        try {
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();
            String groupeReq = "SELECT groupe.* FROM groupe WHERE groupe.Nom = '" + groupeSelected.getNom() + "' AND groupe.Nationalite = '" + groupeSelected.getNationalite() + "';";

            result = stat.executeQuery(groupeReq);
            while (result.next()) {
                groupe.setNom(result.getString("Nom"));
                groupe.setNationalite(result.getString("Nationalite"));
                groupe.setGenre(result.getString("GenreMusical"));
                groupe.setCout(result.getString("Cout"));
                groupe.setPopularite(result.getString("Popularite"));
                groupe.setSiteWeb(result.getString("SiteWeb"));
            }
        } catch (SQLException ex) {
            throw new BDException(ex);
        } finally {
            return groupe;

        }
    }

    public Vector<String> getAllMembreForCombo(GroupeID groupeSelected) throws BDException, LoginException {
        Vector<String> vec = new Vector<String>();
        try {
            Connection connex;
            Statement stat;
            ResultSet result;

            connex = ConnexBD.getInstance();
            stat = connex.createStatement();
            String membres = "SELECT membre_groupe.* FROM membre_groupe WHERE FKNomGroupe = '" + groupeSelected.getNom() + "' AND FKNationaliteGroupe = '" + groupeSelected.getNationalite() + "';";
            result = stat.executeQuery(membres);
            while (result.next()) {
                vec.add(result.getString("Nom") + " " + result.getString("Prenom"));
            }
        } catch (SQLException e) {
            throw new BDException(e);

        } finally {
            return vec;
        }
    }

    public void updateGroupe(Groupe ancGroupe, Groupe newGroupe) throws BDException, GroupeNotAcceptedException {
        try {
            Connection connex;
            Statement stat;
            VerifyData v = new VerifyData();

            String modifGroupe = "UPDATE groupe SET groupe.Nom = '" + v.getSQLString(newGroupe.getNom()) + "' , groupe.Popularite = '" + newGroupe.getPopularite() + "' , groupe.GenreMusical = '" + v.getSQLString(newGroupe.getGenre()) + "' , groupe.Nationalite = '" + newGroupe.getNationalite() + "' , groupe.SiteWeb = '" + newGroupe.getSiteWeb() + "' , groupe.Cout = '" + v.getSQLDoubleString(newGroupe.getCout(), true) + "' WHERE groupe.Nom = '" + ancGroupe.getNom() + "' AND groupe.Nationalite = '" + ancGroupe.getNationalite() + "';";

            connex = ConnexBD.getInstance();
            stat = connex.createStatement();
            int nbLignes = stat.executeUpdate(modifGroupe);

        } catch (SQLException e) {
            throw new BDException(e);
        } catch (LoginException e) {
            throw new BDException(e);
        } catch (VerifyDataException e) {
            throw new GroupeNotAcceptedException(e);
        }
    }

    public void updateRemoveSceneToGroupe(Vector<GroupeScene> vec) throws BDException, LoginException {
        try {
            Connection connex;
            Statement stat;
            String up;

            connex = ConnexBD.getInstance();

            for (GroupeScene g : vec) {
                stat = connex.createStatement();

                up = "UPDATE groupe SET groupe.FKScene = null WHERE groupe.Nom = '" + g.getNom() + "' AND groupe.Nationalite = '" + g.getNationalite() + "';";
                stat = connex.createStatement();
                stat.executeUpdate(up);

            }
        } catch (SQLException e) {
            throw new BDException(e);
        }
    }

    public void updateAddtSceneToGroupe(Vector<GroupeScene> vec) throws BDException, LoginException {
        try {
            Connection connex;
            Statement stat;
            ResultSet result;
            int numScene = 0;
            String up;

            connex = ConnexBD.getInstance();

            for (GroupeScene g : vec) {
                stat = connex.createStatement();
                String sel = "SELECT scene.Numero FROM scene WHERE scene.Nom ='" + g.getLibScene() + "';";
                result = stat.executeQuery(sel);

                if (result.next()) {
                    //On récupère le numéro de la scène... (Je n'ai pas su faire l'update en une seule expression)
                    numScene = result.getInt("Numero");
                    up = "UPDATE groupe SET groupe.FKScene = " + numScene + " WHERE groupe.Nom = '" + g.getNom() + "' AND groupe.Nationalite = '" + g.getNationalite() + "';";
                    stat = connex.createStatement();
                    stat.executeUpdate(up);
                }
            }
        } catch (SQLException e) {
            throw new BDException(e);
        }
    }

    public void updateMembreGroupe(GroupeID groupe, MembreGroupe ancMembre, MembreGroupe newMembre) throws BDException, GroupeNotAcceptedException, LoginException {
        try {
            Connection connex;
            Statement stat;
            VerifyData v = new VerifyData();

            String modifMembre = "UPDATE membre_groupe SET membre_groupe.Nom = '" + v.getSQLString(newMembre.getNom()) + "' , membre_groupe.Prenom = '" + v.getSQLString(newMembre.getPrenom()) + "' , membre_groupe.Pseudo = '" + v.getSQLString(newMembre.getSurnom()) + "' , membre_groupe.Domaine = '" + newMembre.getDomaine() + "' , membre_groupe.Instrument = '" + ((newMembre.getInstrument() != null) ? v.getSQLString(newMembre.getInstrument()) : "") + "' , membre_groupe.DateNaiss = #" + newMembre.getDateNaiss() + "# , membre_groupe.Nationalite = '" + v.getSQLString(newMembre.getNationalite()) + "' WHERE membre_groupe.Nom = '" + ancMembre.getNom() + "' AND membre_groupe.Prenom = '" + ancMembre.getPrenom() + "' AND membre_groupe.FKNomGroupe = '" + groupe.getNom() + "' AND membre_groupe.FKNationaliteGroupe = '" + groupe.getNationalite() + "';";
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();
            System.out.println(modifMembre);
            int nbLignes = stat.executeUpdate(modifMembre);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new BDException(e);
        } catch (VerifyDataException e) {
            throw new GroupeNotAcceptedException(e);
        }
    }
}
