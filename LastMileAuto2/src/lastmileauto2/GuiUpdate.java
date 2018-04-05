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

public class GuiUpdate implements Runnable {

    private int sleepTime;
    private static Random generator = new Random();
    private ControlUI cui;
    private DataStore ds;
    private OptPlan op; 

    public GuiUpdate(DataStore ds, ControlUI cui,OptPlan op) {
        this.cui = cui;
        this.ds = ds;
        this.op = op;
        //sleepTime = generator.nextInt(20000);
        sleepTime = 1000;
    }

    @Override
    public void run() {
        try {
            cui.appendStatus("GuiUpdate startar och kommer att köra i "
                    + sleepTime + " millisekunder.");
            int i = 0;

            /*
            while (ds.updateUIflag == false) {
                
                Thread.sleep(20);
            }*/
            int[] list = op.getIndex();
            while (i <= list.length) {

                Thread.sleep(sleepTime);
                cui.appendStatus("Jag är tråd GuiUpdate! För " + i + ":te gången.");
                
                ds.robotX = (int) (ds.nodeX[list[i]]);
                ds.robotY = (int) (ds.nodeY[list[i]]);
                 System.out.println("Nod är:"+ list[i] );
                System.out.println("RobotX:"+ ds.robotX);
                System.out.println("RobotY:"+ds.robotY);
                i++;
                cui.repaint();
            }
            
        } catch (InterruptedException exception) {
        }
        cui.appendStatus("GuiUpdate är nu klar!");
    }
}
