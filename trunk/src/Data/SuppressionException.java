
package Data;

import java.sql.SQLException;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class SuppressionException extends Exception{
private Exception e;
    public SuppressionException(Exception ex) {
    this.e = ex;
    }

    @Override
    public String toString() {
        return "Suppression non effectuée, veuillez recommencer";
    }

}
