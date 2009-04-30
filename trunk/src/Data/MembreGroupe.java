
package Data;



/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class MembreGroupe {

    private String nom, prenom, nationalite, domaine, instrument, surnom;
    private java.sql.Date dateNaiss;
    private boolean instrumentRequest;



    public MembreGroupe(String nom, String prenom, String surnom, String nationalite, String domaine, String instrument, java.sql.Date dateNaiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.surnom = surnom;
        this.nationalite = nationalite;
        this.domaine = domaine;
        this.instrument = instrument;
        if(instrument == null)
            instrumentRequest = false;
        else
            instrumentRequest = true;
        this.dateNaiss = dateNaiss;
    }

    public boolean isInstrumentRequest() {
        return instrumentRequest;
    }

    public String getSurnom() {
        return surnom;
    }

    public java.sql.Date getDateNaiss() {
        return dateNaiss;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getInstrument() {
        return instrument;
    }

    public String getNationalite() {
        return nationalite;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    
}
