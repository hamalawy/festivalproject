package Controller;

import Data.GestionUser;
import Business.MembreGroupeAgrandi;
import Business.GroupeScene;
import Business.MembreGroupe;
import Data.BDException;
import Data.GestionGroupeBD;
import Data.GestionSceneBD;
import Data.GestionStandBD;
import Business.Groupe;
import Business.GroupeID;
import Business.Stand;
import Data.LoginException;
import Business.Scene;
import Data.ConnexBD;
import View.ConnexBDPanel;
import Data.CriteresRecherche;
import View.groupe.InscrGroupePanel;
import java.util.Vector;
import View.groupe.GroupeNotAcceptedException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

public class Controller {

    public static void closeConnection() throws BDException {
        ConnexBD.close();
    }

    public static boolean connectUser(String user, String pass) throws BDException {
        GestionUser g = new GestionUser();
        return g.connectUser(user, pass);
    }

    public static void createScene(Scene NewScene) throws GroupeNotAcceptedException{
        try {
            GestionSceneBD g = new GestionSceneBD();
            g.createScene(NewScene);
        }catch (BDException ex) {
            throw new GroupeNotAcceptedException(ex);
        } catch (LoginException ex) {
            throw new GroupeNotAcceptedException(ex);
        }
    }

    public static void createStand(Stand newStand) throws BDException {
        try {
            // TODO Auto-generated method stub
            GestionStandBD gs = new GestionStandBD();
            gs.createStand(newStand);
        } catch (BDException ex) {
            throw new BDException(ex);
        } catch (LoginException ex) {
            throw new BDException(ex);
        }
    }

    public static void createGroupe(Groupe newGroupe) throws GroupeNotAcceptedException {
        // TODO Auto-generated method stub
        GestionGroupeBD gs = new GestionGroupeBD();
        try {
            gs.createGroupe(newGroupe);
        } catch (BDException ex) {
            throw new GroupeNotAcceptedException(ex);
        } catch (LoginException ex) {
            throw new GroupeNotAcceptedException(ex);
        }

    }

    public static void addMembreToGroupe(GroupeID groupe, MembreGroupe membre) throws GroupeNotAcceptedException {
        try {
            GestionGroupeBD gs = new GestionGroupeBD();
            gs.addMembreToGroupe(groupe, membre);
        } catch (BDException ex) {
            throw new GroupeNotAcceptedException(ex);
        } catch (LoginException ex) {
            throw new GroupeNotAcceptedException(ex);
        }
    }

    public static void deleteGroupe(GroupeID groupe) throws BDException {
        GestionGroupeBD gg = new GestionGroupeBD();
        gg.deleteGroupe(groupe);
    }

    public static void deleteMembreGroupe(MembreGroupe membre, GroupeID groupe) throws BDException {
        GestionGroupeBD gs = new GestionGroupeBD();
        gs.deleteMembreGroupe(membre, groupe);
    }

    public static Vector<String> getAllGenre() throws BDException {
        GestionGroupeBD gs = new GestionGroupeBD();
        return gs.getAllGenre();
    }

    public static Vector<GroupeScene> getAllGroupeGenre(String genre) throws BDException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllGroupeGenre(genre);
    }

    public static Vector<GroupeScene> getAllGroupeGenreByScene(String scene) throws BDException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllGroupeGenreByScene(scene);
    }

    public static Vector <GroupeScene> getAllGroupeNoScene() throws BDException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllGroupeNoScene();
    }
    public static Vector<String> getAllLibScene() throws BDException {
        GestionSceneBD gg = new GestionSceneBD();
        return gg.getAllLibScene();
    }

    public static Vector<MembreGroupe> getAllMembreGroupe(GroupeID groupeSelected) throws BDException, LoginException {
        GestionGroupeBD gs = new GestionGroupeBD();
        return gs.getAllMembreGroupe(groupeSelected);
    }

    public static Vector<String> getAllGroupeNationalite() throws BDException {
        GestionGroupeBD gg = new GestionGroupeBD();
        try {
            return gg.getAllGroupeNationalite();
        } catch (LoginException ex) {
            throw new BDException(ex);
        }
    }

    public static Vector<String> getAllMembreGroupeNationalite() throws BDException, LoginException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllMembreGroupeNationalite();
    }

    public static Vector<String> getAllInstruments() throws BDException, LoginException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllInstrument();
    }

    public static Vector<GroupeID> getAllGroupeForList() throws BDException, LoginException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllGroupeForList();
    }

    public static Vector<MembreGroupeAgrandi> getAllResultMembre(CriteresRecherche c) throws BDException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllResultMembre(c);

    }

    public static Groupe getGroupeSelected(GroupeID nomGroupeSelected) throws BDException, LoginException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getGroupeSelected(nomGroupeSelected);
    }

    public static Vector<String> getAllMembreForCombo(GroupeID groupeSelected) throws BDException, LoginException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllMembreForCombo(groupeSelected);
    }

    public static Vector<String> getIdentifiantConnex() {
        ConnexBDPanel con = new ConnexBDPanel();
        if(JOptionPane.showConfirmDialog(null,con , "Connexion", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
            Vector<String> vec = con.getID();
            return vec;
        }
        else {
            System.exit(0);
            return null;
        }
        
    }

  /*  public static String getSceneGroupe() {
        GestionSceneBD gg = new GestionSceneBD();
        return gg.getSceneGroupe()
    }*/

    public static void updateGroupe(Groupe ancGroupe, Groupe newGroupe) throws GroupeNotAcceptedException {
        try {
            GestionGroupeBD gg = new GestionGroupeBD();
            gg.updateGroupe(ancGroupe, newGroupe);
        } catch (BDException ex) {
            throw new GroupeNotAcceptedException(ex);
        } 
    }

    public static void updateRemoveSceneToGroupe(Vector<GroupeScene> vec) throws BDException{
        GestionGroupeBD gg = new GestionGroupeBD();
        try {
            gg.updateRemoveSceneToGroupe(vec);
        } catch (LoginException ex) {
            throw new BDException(ex);
        }
    }

    public static void updateAddSceneToGroupe(Vector<GroupeScene> vec) throws BDException{
        GestionGroupeBD gg = new GestionGroupeBD();
        try {
            gg.updateAddtSceneToGroupe(vec);
        } catch (LoginException ex) {
            throw new BDException(ex);
        }
    }

    public static void updateMembreGroupe(GroupeID groupe, MembreGroupe ancMembre, MembreGroupe newMembre) throws GroupeNotAcceptedException {
        try {
            GestionGroupeBD gg = new GestionGroupeBD();
            gg.updateMembreGroupe(groupe, ancMembre, newMembre);
        } catch (BDException ex) {
            throw new GroupeNotAcceptedException(ex);
        } catch (LoginException ex) {
            throw new GroupeNotAcceptedException(ex);
        }
    }
}
