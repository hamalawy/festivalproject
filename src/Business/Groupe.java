package Business;

import java.util.Vector;

public class Groupe extends GroupeID{
	private String popularite, siteWeb, genre;
	private String cout;
    private Vector<MembreGroupe> vecMembres = new Vector<MembreGroupe>();

    public Groupe(String nom, String nationalite, String genre, String popularite, String siteWeb, String cout) {
        super(nom, nationalite);
        this.genre = genre;
        this.popularite = popularite;
        this.siteWeb = siteWeb;
        this.cout = cout;
    }

    public Groupe() {
        super(null,null);
    }





    public void setCout(String cout) {
        this.cout = cout;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public void setPopularite(String popularite) {
        this.popularite = popularite;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public Vector<MembreGroupe> getVecMembres() {
        return vecMembres;
    }

    public void setVecMembres(Vector<MembreGroupe> vecMembres) {
        this.vecMembres = vecMembres;
    }

	public String getGenre() {
		return genre;
	}

	public String getPopularite() {
		return popularite;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public String getCout() {
		return cout;
	}
	

}
