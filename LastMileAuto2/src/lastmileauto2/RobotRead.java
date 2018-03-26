/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastmileauto2;

/**
 *
 * @author Carllindgren
 */
import java.util.Random;

public class RobotRead implements Runnable {

    private int sleepTime;
    private static Random generator = new Random();
    private ControlUI cui;
    private DataStore ds;

    public RobotRead(DataStore ds, ControlUI cui) {

        this.cui = cui;

        this.ds = ds;
        sleepTime = generator.nextInt(20000);
    }

    @Override
    public void run() {
        try {
            cui.appendStatus("RobotRead kommer att köra i " + sleepTime + " millisekunder.");

            int i = 1;
            while (i <= 20) {
                
                Thread.sleep(sleepTime / 20);
                cui.appendStatus("Jag är tråd RobotRead! För " + i + ":te gången.");
                if (i==10){
                    ds.updateUIflag=true;
                                       
                }
                i++;
            }
        } catch (InterruptedException exception) {
        }
        cui.appendStatus("RobotRead är nu klar!");

    }

}
