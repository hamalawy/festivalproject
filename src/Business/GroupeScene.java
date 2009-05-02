
package Business;

/**
 *
 * @author Gérôme Quentin
 * @author Scaillet Bruno
 */
public class GroupeScene extends GroupeID{
    private String libScene;
    private String genre;


    public GroupeScene(String nom, String nationalite, String libScene, String genre) {
        super(nom, nationalite);
        this.libScene = libScene;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLibScene() {
        return libScene;
    }

    public void setLibScene(String libScene) {
        this.libScene = libScene;
    }
    

}
