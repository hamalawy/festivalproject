package View;

/**
 *
 * @author Cramike
 */
public class VerifyDataException extends Exception{

    public VerifyDataException() {
    }

    @Override
    public String toString(){
        return "La chaîne donnée n'a pas su être traitée\n\n<i>Vérifier que la chaîne est conforme aux demandes";
    }
}
