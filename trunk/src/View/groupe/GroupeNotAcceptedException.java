
package View.groupe;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
class GroupeNotAcceptedException extends Exception{

    public GroupeNotAcceptedException() {
    }

    @Override
    public String toString()
    {
        return "Veuillez compléter tous les champs pour l'enregistrement du groupe svp";
    }
}
