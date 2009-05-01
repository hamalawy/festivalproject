package Data;

public class Scene 
{
    private int numero, capaciteMax, superficie, nbIngenieur;
    private String nom, description;

    public Scene(int n, String nom, int cm, int s, int nbI, String d) {
        this.numero=n;
        this.nom=nom;
        this.capaciteMax=cm;
        this.superficie=s;
        this.nbIngenieur=nbI;
        this.description=d;
    }
    
    public int getCapaciteMax ()
    {
        return capaciteMax;
    }
    
    public int getSuperficie ()
    {
        return superficie;
    }
    
    public int getNbIngenieur ()
    {
        return nbIngenieur;
    }
    
    public String getNom ()
    {
        return nom;
    }
    
    public String getDescription ()
    {
        return description;
    }
}
