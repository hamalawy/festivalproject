package Controller;

import Data.MembreGroupe;
import Data.BDException;
import Data.GestionGroupeBD;
import Data.GestionStandBD;
import Data.Groupe;
import Data.GroupeID;
import Data.Stand;
import Data.LoginException;
import java.util.Vector;
import View.groupe.GroupeNotAcceptedException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {

    public static void createStand(Stand newStand) throws BDException, LoginException {
        // TODO Auto-generated method stub
        GestionStandBD gs = new GestionStandBD();
        gs.createStand(newStand);
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

    public static void addMembreToGroupe(GroupeID groupe, MembreGroupe membre) throws GroupeNotAcceptedException{
        try {
            GestionGroupeBD gs = new GestionGroupeBD();
            gs.addMembreToGroupe(groupe, membre);
        } catch (BDException ex) {
            throw new GroupeNotAcceptedException(ex);
        } catch (LoginException ex) {
            throw new GroupeNotAcceptedException(ex);
        }
    }

    public static void deleteMembreGroupe(MembreGroupe membre) throws BDException, GroupeNotAcceptedException {
        GestionGroupeBD gs = new GestionGroupeBD();
        gs.deleteMembreGroupe(membre);
    }

    public static Vector<String> getAllGenre() throws BDException, LoginException {
        GestionGroupeBD gs = new GestionGroupeBD();
        return gs.getAllGenre();
    }

    public static Vector<MembreGroupe> getAllMembreGroupe(GroupeID groupeSelected) throws BDException, LoginException {
        GestionGroupeBD gs = new GestionGroupeBD();
        return gs.getAllMembreGroupe(groupeSelected);
    }

    public static Vector<String> getAllGroupeNationalite() throws BDException, LoginException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllGroupeNationalite();
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

    public static Groupe getGroupeSelected(GroupeID nomGroupeSelected) throws BDException, LoginException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getGroupeSelected(nomGroupeSelected);
    }

    public static Vector<String> getAllMembreForCombo(GroupeID groupeSelected) throws BDException, LoginException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllMembreForCombo(groupeSelected);
    }
}
