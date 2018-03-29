/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agvg5;


import java.io.*;
import javax.microedition.io.*;
import javax.bluetooth.*;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author itn
 */
public class BluetoothTransmitter implements Runnable {
    private int testar=123;
    private static Random generator = new Random();
    private int sleepTime;
    private String tot;

    public BluetoothTransmitter(String BlueNr, String ChannelNr) {

        tot = "btspp://" + BlueNr + ":" + ChannelNr + "";

    }

    public void run() {
  
        sleepTime = generator.nextInt(20000);
        try {
            //  cui.appendStatus("RobotRead kommer att köra i " + sleepTime + "millisekunder.");
          
            int i = 1;
            while (i==1) {

                Thread.sleep(1);

                try {

                    StreamConnection anslutning = (StreamConnection) Connector.open(tot);
                    //StreamConnection anslutning = (StreamConnection) Connector.open("btspp://B827EB003082:22"); // här stoppar vi in adressen
                    PrintStream bluetooth_ut = new PrintStream(anslutning.openOutputStream());
                    bluetooth_ut.append("JAG ÄR LABBDATOR66666666666666666666666666666666666666");
                   // bluetooth_ut.append("hej ");
                    Thread.sleep(1000);
                    anslutning.close();

                } catch (Exception e) {

                    System.out.print(e.toString());
                }
                i++;

            }

        } catch (InterruptedException exception) {

        }

    }

}

