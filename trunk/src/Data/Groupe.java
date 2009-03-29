package Data;

public class Groupe {
	private String nom, nationalite, genre, popularite, siteWeb;
	private double cout;
    
	public Groupe(String nom, String nationalite, String genre,
			String popularite, String siteWeb, double cout) {
		super();
		this.nom = nom;
		this.nationalite = nationalite;
		this.genre = genre;
		this.popularite = popularite;
		this.siteWeb = siteWeb;
		this.cout = cout;
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
	public double getCout() {
		return cout;
	}
	

}
