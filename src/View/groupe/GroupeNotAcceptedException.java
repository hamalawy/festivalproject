
package View.groupe;


/**
 *
 * @author G�r�me Quentin
 * @author Scaillet Bruno
 */
public class GroupeNotAcceptedException extends Exception{

    private Exception ex;

    public GroupeNotAcceptedException(Exception ex) {
        ex = new Exception();
    }

    public GroupeNotAcceptedException() {

    }

    @Override
    public String toString()
    {
        if(ex != null)
            return ex.toString();
        else
            return "Impossible d'inscrire le groupe, veuillez v�rifier les champs";

    }
}
