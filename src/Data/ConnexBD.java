package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnexBD {

    private static String nomDB,  pass;
    private static Connection uniqueInstance;

    public static void close() throws BDException {
        try {
            if (uniqueInstance != null && !uniqueInstance.isClosed()) {
                uniqueInstance.close();
            }
        } catch (SQLException ex) {
            throw new BDException(ex);
        }
    }

    public static Connection getInstance() throws BDException, LoginException {
        Vector<String> vec;
        try {
            if (uniqueInstance == null || uniqueInstance.isClosed()) {

                vec = Controller.Controller.getIdentifiantConnex();
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                uniqueInstance = DriverManager.getConnection("jdbc:odbc:" + vec.elementAt(0), "Crail", vec.elementAt(1));
            }
        } catch (ClassNotFoundException e) {
            throw new BDException(e);
        } catch (SQLException e) {
            throw new BDException(e);
        }

        return uniqueInstance;
    }
}