
package Data;

import java.sql.SQLException;

/**
 *
 * @author G�r�me Quentin
 * @author Scaillet Bruno
 */
public class SuppressionException extends Exception{
private Exception e;
    public SuppressionException(Exception ex) {
    this.e = ex;
    }

    @Override
    public String toString() {
        return "Suppression non effectu�e, veuillez recommencer";
    }

}
