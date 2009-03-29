/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


/**
 *
 * @author Cramike
 */
public class ThreadBarreInfo extends Thread {

    private BarreInfo barreInfo;
    private long time;

    public ThreadBarreInfo(BarreInfo barreInfo) {
        this.barreInfo = barreInfo;
        this.setPriority(Thread.MIN_PRIORITY);
    }

    @Override
    public void run() {
        while (true) {
            if (barreInfo.isRequestReceived()) {
                try {
                    Thread.sleep(3000);
                    barreInfo.setThreadText();
                } catch (IllegalThreadStateException il) {
                    System.out.println("Erreur de illegalThreadStateException");
                } catch (InterruptedException ex) {
                    System.out.println("Erreur de thread");
                    System.exit(0);
                }
            } 
        }
    }
}
