package Data;

import java.sql.SQLException;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
class ModifierMembreGroupeException extends Exception{

    private Exception e;

    public ModifierMembreGroupeException(Exception ex) {
        this.e = e;

    }

    public String toString() {
        return "Le membre n'a pas été modifié, veuillez recommencer";
    }
}
