/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agvg5;

/**
 *
 * @author itn
 */
import java.io.*;
import javax.microedition.io.*;
import javax.bluetooth.*;
// HELLO GITHUB 

public class BluetoothTransceiver_newtest1 implements Runnable {

    private String meddelande_in = "BAJS";

    public BluetoothTransceiver_newtest1() {

    }

    public void run() {

        try {
            StreamConnection anslutning = (StreamConnection) Connector.open(
                    "btspp://B827EB003082:22"
            );
            PrintStream bluetooth_ut = new PrintStream(anslutning.openOutputStream());
            BufferedReader bluetooth_in = new BufferedReader(new InputStreamReader(anslutning.openInputStream()));

            BufferedReader tangentbord= new BufferedReader(new InputStreamReader(System.in));

            
            String meddelande_in ="";
     

            while (true) {

                String meddelande_ut = tangentbord.readLine();
                if (meddelande_ut
                        == null) {
                    break;
                }

                bluetooth_ut.println(meddelande_ut);
                meddelande_in = bluetooth_in.readLine();
                System.out.println("Mottaget: " + meddelande_in);

            }
            anslutning.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    public String get_QR() {
        return meddelande_in;
    }
}
