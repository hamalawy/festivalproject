
package Data;

/**
 *
 * @author G�r�me Quentin
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
