package Data;

import java.util.GregorianCalendar;

public class Stand {

	private String typeProduit;
	private int textNbPersonnelRequis;
	private String textSouscripteur;
	private GregorianCalendar dateAjout;
	private String textDescription;

	public Stand(String typeProduit, int textNbPersonnelRequis,
			String textSouscripteur, String textDescription) {
		this.typeProduit = typeProduit;
		this.textNbPersonnelRequis = textNbPersonnelRequis;
		this.textSouscripteur = textSouscripteur;
		this.textDescription = textDescription;
		dateAjout = new GregorianCalendar();
		
	}

	public String getTypeProduit() {
		return typeProduit;
	}

	public int getTextNbPersonnelRequis() {
		return textNbPersonnelRequis;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public String getTextSouscripteur() {
		return textSouscripteur;
	}

	public GregorianCalendar getDateAjout() {
		return dateAjout;
	}

}
