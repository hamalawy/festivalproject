package Data;

import java.util.Vector;

public class Groupe {
	private String nom, nationalite, genre, popularite, siteWeb;
	private String cout;
    private Vector<MembreGroupe> vecMembres = new Vector<MembreGroupe>();
	public Groupe(String nom, String nationalite, String genre,
			String popularite, String siteWeb, String cout, Vector<MembreGroupe> vecMembres) {
		super();
		this.nom = nom;
		this.nationalite = nationalite;
		this.genre = genre;
		this.popularite = popularite;
		this.siteWeb = siteWeb;
		this.cout = cout;
        this.vecMembres = vecMembres;
	}

    public Groupe(String nom, String nationalite, String genre,
			String popularite, String siteWeb, String cout) {
        this(nom,nationalite,genre,popularite,siteWeb,cout, null);
    }

    Groupe() {
    }

    public void setCout(String cout) {
        this.cout = cout;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

	public String getNom() {
		return nom;
	}
	public String getNationalite() {
		return nationalite;
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
