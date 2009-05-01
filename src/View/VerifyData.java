package View;

/**
 * Classe vérifiant des strings fournis afin de pouvoir les introduire sans
 * risque dans la base de donnée ACCESS. Pour ce faire, les caractères provoquant
 * des erreurs lors de l'ajout dans la DB sont complétés par des "\"
 *
 * @author Cramike
 * @version 0.1
 * @see String
 *
 */
public class VerifyData {

    public VerifyData() {
    }

    public String getSQLDoubleString(String str, boolean avecVirgule) throws VerifyDataException {
        String strModif = "";
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        strModif += str.charAt(i);
                        break;
                    case ',':
                    case '.':
                        if (avecVirgule) {
                            if (i == 0) {
                                strModif += "0.";
                            } else if (i > 1 && str.charAt(i - 1) != '.') {
                                strModif += ".";
                            }
                        }
                        break;
                    default:
                        throw new VerifyDataException();

                }
            }
        } else {
            throw new VerifyDataException();
        }

        return strModif;
    }

    private double getSQLDouble(String str, boolean avecVirgule) throws VerifyDataException {

        return Double.parseDouble(getSQLDoubleString(str, avecVirgule));
    }

    public int getSQLInt(String str) throws VerifyDataException {
        return (int) Math.round(getSQLDouble(str, true));
    }

    /**
     * Cette fonction permet de récupérer un @URL{String} modifée pour son insertion
     * dans la base de donnée ACCESS
     *
     * @param str Prend en paramètre la chaîne que l'on veut adapter
     * @return modStr Retourne la chaîne modifiée
     * @throws View.VerifyDataException
     * @see String
     */
    public String getSQLString(String str) throws VerifyDataException {
        String modStr = "";
        if (str != null) {
            str = str.trim();
            for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case '\'':
                        modStr += "'";
                        break;
                }
                modStr += str.charAt(i);
            }
        } else {
            throw new VerifyDataException();
        }
        if (modStr.length() > 0) {
            modStr = modStr.substring(0, 1).toUpperCase() + modStr.substring(1).toLowerCase();
        }
        return modStr;
    }
}
