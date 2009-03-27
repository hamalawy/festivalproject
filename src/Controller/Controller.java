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

	public static void createGroupe(Groupe newGroupe) throws BDException, LoginException {
		// TODO Auto-generated method stub
		GestionGroupeBD gs = new GestionGroupeBD();
		gs.createGroupe(newGroupe);
	}

    public static Vector<MembreGroupe> getAllMembreGroupe() throws BDException, LoginException {
        GestionGroupeBD gs = new GestionGroupeBD();
        return gs.getAllMembreGroupe();
    }

    public static Vector<String> getAllNationalite() throws BDException, LoginException
    {
        GestionGroupeBD gg = new GestionGroupeBD();
        return gg.getAllNationalite();
    }
}
