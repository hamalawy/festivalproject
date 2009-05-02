
package Data;

import View.VerifyData;
import View.VerifyDataException;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class RequeteMembreSearch {

    public RequeteMembreSearch() {
    }

    public String getRequete(CriteresRecherche c) throws VerifyDataException {
        try {
            VerifyData v = new VerifyData();
            String req = "SELECT membre_groupe.*, groupe.Nom, groupe.Nationalite, groupe.GenreMusical "
                    + "FROM membre_groupe, groupe " + "WHERE groupe.Nom = membre_groupe.FKNomGroupe "
                    + "AND groupe.Nationalite = membre_groupe.FKNationaliteGroupe";
            if (!c.getNationaliteGroupe().isEmpty()) {
                req += " AND groupe.Nationalite ='" + v.getSQLString(c.getNationaliteGroupe()) + "'";
            }
            if (!c.getNomGroupe().isEmpty()) {
                req += " AND groupe.Nom LIKE '%" + v.getSQLString(c.getNomGroupe()) + "%'";
            }
            if (!c.getNomMembre().isEmpty()) {
                req += " AND membre_groupe.Nom LIKE '%" + v.getSQLString(c.getNomMembre()) + "%'";
            }
            if (!c.getPrenomMembre().isEmpty()) {
                req += " AND membre_groupe.Prenom LIKE '%" + v.getSQLString(c.getPrenomMembre()) + "%'";
            }
            if (!c.getInstrument().isEmpty()) {
                req += " AND membre_groupe.Instrument = '" + v.getSQLString(c.getInstrument()) + "'";
            }
            req += ";";
            return req;
        } catch (VerifyDataException ex) {
            throw new VerifyDataException();
        }
    }   
}
