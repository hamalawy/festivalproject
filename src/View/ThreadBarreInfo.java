/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cramike
 */
public class ThreadBarreInfo extends Thread{
    private BarreInfo barreInfo;
    private long time;
    public ThreadBarreInfo(BarreInfo barreInfo)
    {
        this.barreInfo = barreInfo;
        this.setPriority(Thread.MIN_PRIORITY);
    }

    @Override
    public void run()
    {
            System.out.println("Entree dans le thread");
            try {
                Thread.sleep(2000);
            }
            catch (IllegalThreadStateException il)
            {
                System.out.println("Erreur de illegalThreadStateException");
            }
            catch (InterruptedException ex) {
                System.out.println("Erreur de thread");
                System.exit(0);
            }
        System.out.println("Sortie du thread");
        barreInfo.getText().setText(null);

        this.suspend();


    }
}
