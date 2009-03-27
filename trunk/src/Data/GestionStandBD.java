package Data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class GestionStandBD {

	
	private String ajout;
	private Object String;

	public void createStand(Stand newStand) throws BDException, LoginException
	{
		Connection connex;
		
		try {
			connex = ConnexBD.getInstance();
			Statement stat = connex.createStatement();
			ajout = "INSERT INTO stand (typeProduit, nbPersonnelRequis, souscripteur, description) VALUES "
													+"('"+newStand.getTypeProduit()
													+"','"+newStand.getTextNbPersonnelRequis()
													+"','"+newStand.getTextSouscripteur()
													+"','"+newStand.getTextDescription()
													+"');";
			int nbIns = stat.executeUpdate(ajout);
			
													
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			throw new BDException(e);
		}
	}
}
