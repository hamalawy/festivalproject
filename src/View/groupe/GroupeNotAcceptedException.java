
package View.groupe;

/**
 *
 * @author G�r�me Quentin
 * @author Scaillet Bruno
 */
class GroupeNotAcceptedException extends Exception{

    public GroupeNotAcceptedException() {
    }

    @Override
    public String toString()
    {
        return "Veuillez compl�ter tous les champs pour l'enregistrement du groupe svp";
    }
}
