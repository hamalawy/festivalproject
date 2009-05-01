/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import View.VerifyData;
import View.VerifyDataException;
import View.groupe.GroupeNotAcceptedException;
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
                    "','" + ((m.getInstrument()!=null)?v.getSQLString(m.getInstrument()):"") + "');";
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
                            "','" + ((m.getInstrument()!=null)?v.getSQLString(m.getInstrument()):"") + "');";
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

    public Vector<String> getAllGenre() throws BDException, LoginException {
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

    public void updateMembreGroupe(GroupeID groupe, MembreGroupe ancMembre, MembreGroupe newMembre) throws BDException, GroupeNotAcceptedException, LoginException {
        try {
            Connection connex;
            Statement stat;
            VerifyData v = new VerifyData();

            String modifMembre = "UPDATE membre_groupe SET membre_groupe.Nom = '" + v.getSQLString(newMembre.getNom())
                    + "' , membre_groupe.Prenom = '" + v.getSQLString(newMembre.getPrenom()) + "' , membre_groupe.Pseudo = '"
                    + v.getSQLString(newMembre.getSurnom()) + "' , membre_groupe.Domaine = '" + newMembre.getDomaine()
                    + "' , membre_groupe.Instrument = '" + ((newMembre.getInstrument()!=null)?v.getSQLString(newMembre.getInstrument()):"") + "' , membre_groupe.DateNaiss = #"
                    + newMembre.getDateNaiss() + "# , membre_groupe.Nationalite = '" + v.getSQLString(newMembre.getNationalite())
                    + "' WHERE membre_groupe.Nom = '" + ancMembre.getNom() + "' AND membre_groupe.Prenom = '" + ancMembre.getPrenom()
                    + "' AND membre_groupe.FKNomGroupe = '" + groupe.getNom() + "' AND membre_groupe.FKNationaliteGroupe = '"
                    + groupe.getNationalite() + "';";
            connex = ConnexBD.getInstance();
            stat = connex.createStatement();
            System.out.println(modifMembre);
            int nbLignesSuppr = stat.executeUpdate(modifMembre);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new BDException(e);
        } catch (VerifyDataException e) {
            throw new GroupeNotAcceptedException(e);
        }
    }
}
