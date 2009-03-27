package Data;

public class BDException extends Exception {
	private Exception e;
	public BDException(Exception e) {
		this.e=e;
	}
	
    @Override
	public String toString()
	{
		return "Erreur au niveau de la connexion de la BD\nErreur : "+e.getMessage();
	}

}
