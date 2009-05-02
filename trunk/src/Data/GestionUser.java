package Data;

import Data.BDException;
import Data.ConnexBD;
import Data.LoginException;
import View.VerifyData;
import View.VerifyDataException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class GestionUser {

    public boolean connectUser(String user, String pass) throws BDException {
        Connection connex;
        Statement stat;
        ResultSet result;
        VerifyData v = new VerifyData();
        boolean reponse = false;
        try {
            connex = ConnexBD.getInstance();
            String req = "SELECT utilisateur.* FROM utilisateur WHERE utilisateur.Username = '" + v.getSQLString(user) + "'" + " AND utilisateur.Password ='" + v.getSQLString(pass) + "';";
            stat = connex.createStatement();
            result = stat.executeQuery(req);
            if (result.next()) {
                reponse = true;
            } else {
                reponse = false;
            }
        } catch (LoginException ex) {
            throw new BDException(ex);
        } catch (SQLException ex) {
            throw new BDException(ex);
        } catch (VerifyDataException ex) {
            throw new BDException(ex);
        } finally {
            return reponse;
        }
    }
}
