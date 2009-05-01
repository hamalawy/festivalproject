package Data;

public class BDException extends Exception {
	private Exception e;
	public BDException(Exception e) {
		this.e=e;
	}
	
    @Override
	public String toString()
	{
		return "Erreur avec la DB, Erreur : "+e.toString();
	}

}
