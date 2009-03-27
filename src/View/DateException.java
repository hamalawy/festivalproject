package View;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cramike
 */
public class DateException extends Exception{
    private Exception e;

    public DateException(Exception e) {
        this.e = e;
    }

    public String toString()
    {
        return "Date incorrecte";
    }

}
