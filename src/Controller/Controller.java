package Controller;

import Data.MembreGroupe;
import Data.BDException;
import Data.GestionGroupeBD;
import Data.GestionStandBD;
import Data.Groupe;
import Data.Stand;
import Data.LoginException;
import java.util.Vector;

public class Controller {

    public static void createStand(Stand newStand) throws BDException, LoginException {
        // TODO Auto-generated method stub
        GestionStandBD gs = new GestionStandBD();
        gs.createStand(newStand);
    }

    public static void createGroupe(Groupe newGroupe, Vector<MembreGroupe> vectMembreGroupe) throws BDException, LoginException {
        // TODO Auto-generated method stub
        GestionGroupeBD gs = new GestionGroupeBD();
        gs.createGroupe(newGroupe, vectMembreGroupe);
    }

    public static void deleteMembreGroupe(MembreGroupe membre) {
        GestionGroupeBD gs = new GestionGroupeBD();
        gs.deleteMembreGroupe(membre);
    }

    public static Vector<String> getAllGenre() throws BDException, LoginException {
        GestionGroupeBD gs = new GestionGroupeBD();
        return gs.getAllGenre();
    }

    public static Vector<MembreGroupe> getAllMembreGroupe() throws BDException, LoginException {
        GestionGroupeBD gs = new GestionGroupeBD();
        return gs.getAllMembreGroupe();
    }

    public static Vector<String> getAllGroupeNationalite() throws BDException, LoginException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllGroupeNationalite();
    }

    public static Vector<String> getAllMembreGroupeNationalite() throws BDException, LoginException {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllMembreGroupeNationalite();
    }
}
