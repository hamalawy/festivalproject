package Data;

import View.ConnexPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnexBD {
    private static String nomDB, pass;
    private static Connection uniqueInstance;


    public static Connection getInstance() throws BDException, LoginException {
        return getInstance(nomDB, pass);
    }

    public static Connection getInstance(String nomDB, String pass) throws BDException, LoginException {
        ConnexBD.nomDB = nomDB;
        ConnexBD.pass = pass;
        if (uniqueInstance == null) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                uniqueInstance = DriverManager.getConnection("jdbc:odbc:"+nomDB, "Crail", pass);
            } catch (ClassNotFoundException e) {
                throw new BDException(e);
            } catch (SQLException e) {
                throw new BDException(e);
            }
        }
        return uniqueInstance;
    }
}
