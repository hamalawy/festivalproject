package Data;

public class BDException extends Exception {
	private Exception e;
	public BDException(Exception e) {
		this.e=e;
	}
	
    @Override
    public String getMessage() {
        return toString()+" Detail : \n"+e.getMessage();
    }

    @Override
	public String toString()
	{
		return "Erreur avec la base de donn�es, veuillez contacter l'administrateur r�seau";
	}

}
