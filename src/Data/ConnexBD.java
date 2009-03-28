package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnexBD {

	private static Connection uniqueInstance;
	private static DemandeConnexBDPanel demandeConnex;
	public static Connection getInstance() throws BDException, LoginException
	{
		if(uniqueInstance == null)
		{
            demandeConnex = new DemandeConnexBDPanel();
			JOptionPane.showMessageDialog(null, demandeConnex, "Connexion BD", JOptionPane.INFORMATION_MESSAGE);
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                uniqueInstance = DriverManager.getConnection("jdbc:odbc:festival", demandeConnex.getUser(), demandeConnex.getPassword());
                    
            } catch (ClassNotFoundException e) {
				throw new BDException(e);
			} catch (SQLException e) {
				throw new BDException(e);
			}
		}
		return uniqueInstance;
	}
}
