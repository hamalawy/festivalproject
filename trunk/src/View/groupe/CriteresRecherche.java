package View.groupe;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class CriteresRecherche {

    private String nationaliteGroupe,  nomGroupe,  nomMembre,  prenomMembre,  pseudoMembre;

    public CriteresRecherche() {
        nationaliteGroupe = null;
        nomGroupe = null;
        nomMembre = null;
        prenomMembre = null;
        pseudoMembre = null;

    }

    public boolean isEmpty() {
        if (nationaliteGroupe == null && nomGroupe == null && nomMembre == null && prenomMembre == null && pseudoMembre==null)
            return true;
        else
            return false;
    }

    public String getNationaliteGroupe() {
        return nationaliteGroupe;
    }

    public void setNationaliteGroupe(String nationaliteGroupe) {
        this.nationaliteGroupe = nationaliteGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public String getPseudoMembre() {
        return pseudoMembre;
    }

    public void setPseudoMembre(String pseudoMembre) {
        this.pseudoMembre = pseudoMembre;
    }
}
