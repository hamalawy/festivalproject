
package Data;

import java.sql.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class MembreGroupe {

    private String nom, prenom, nationalite, domaine, instrument, surnom;
    private Date dateNaiss;


    public MembreGroupe(String nom, String prenom, String surnom, String nationalite, String domaine, String instrument, Date dateNaiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.surnom = surnom;
        this.nationalite = nationalite;
        this.domaine = domaine;
        this.instrument = instrument;
        this.dateNaiss = dateNaiss;
    }

    public String getSurnom() {
        return surnom;
    }

    public Date getDateNaiss() {
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
