
package Business;


/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class GroupeID{
    private String nom, nationalite;

    public GroupeID(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    
}
