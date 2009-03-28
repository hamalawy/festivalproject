package Data;

import View.DemandeConnexDialog;
import java.awt.GraphicsConfiguration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnexBD {

	private static Connection uniqueInstance;
	private static DemandeConnexDialog demandeConnex;
	public static Connection getInstance() throws BDException, LoginException
	{
		if(uniqueInstance == null)
		{
            demandeConnex = new DemandeConnexDialog(null, true);
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                uniqueInstance = DriverManager.getConnection("jdbc:odbc:festival", demandeConnex.getConnexPanel().getUser(), demandeConnex.getConnexPanel().getPassword());
                    
            } catch (ClassNotFoundException e) {
				throw new BDException(e);
			} catch (SQLException e) {
				throw new BDException(e);
			}
		}
		return uniqueInstance;
	}
    public static boolean isInstanced()
    {
        if(uniqueInstance == null)
            return false;
        else
            return true;
    }
}
