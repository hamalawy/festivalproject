
package Business;

import Business.MembreGroupe;
import java.sql.Date;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class MembreGroupeAgrandi extends MembreGroupe{
    private String nomGroupe, nationaliteGroupe;
    private String genre;

    public MembreGroupeAgrandi() {
        super(null,null,null,null,null,null,null);
    }

    public MembreGroupeAgrandi(String nom, String prenom, String surnom, String nationalite, String domaine, String instrument, Date dateNaiss, String nomGroupe, String nationaliteGroupe, String genre) {
        super(nom, prenom, surnom, nationalite, domaine, instrument, dateNaiss);
        this.nomGroupe = nomGroupe;
        this.nationaliteGroupe = nationaliteGroupe;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
    


}
