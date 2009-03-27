
package Data;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class LoginException extends Exception{

    public LoginException() {
    }


    @Override
    public String toString()
    {
        return "Utilisateur et/ou mot de passe incorrect";
    }
}
