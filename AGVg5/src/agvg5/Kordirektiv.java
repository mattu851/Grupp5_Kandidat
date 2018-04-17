/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agvg5;


/**
 *
 * @author Gustav
 */

public class Kordirektiv implements Runnable {
    
    private int sleepTime;
    
    private DataStore1 ds;
    private int qr;
    private OptPlan op;
    private int dir;
    
  
    public Kordirektiv(int qr_in, OptPlan op) {
        qr = qr_in;
        sleepTime = 1000;
        this.op = op;
    }

    @Override
    public void run() {
        try {
            
           int[] list = op.getIndex();
            
           System.out.println("hej" + list[4]);
           Thread.sleep(sleepTime);

        } catch (InterruptedException exception) {
        }
        //cui.appendStatus("GuiUpdate är nu klar!");
    }
    
    public int getDir(){
        
        return dir;
    }
    
    
}
