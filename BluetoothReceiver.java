/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agvg5;

import java.io.*;
import java.util.Random;
import javax.microedition.io.*;
import javax.bluetooth.*;

public class BluetoothReceiver implements Runnable {

    private static Random generator = new Random();
    private int sleepTime;

    public void BluetoothReceiver() {

    }

    public void run() {
        try {

            while (true) {
                try {
                    StreamConnectionNotifier service = (StreamConnectionNotifier) Connector.open("btspp://localhost:" + new UUID(0x1101).toString() + ";name=TNK111-Grupp5_Receiver");
                    StreamConnection anslutning = (StreamConnection) service.acceptAndOpen();
                    InputStream bluetooth_in = anslutning.openInputStream();
                    byte buffer[] = new byte[80];
                    int antal_bytes = bluetooth_in.read(buffer);
                    String mottaget = new String(buffer, 0, antal_bytes);
                    System.out.println("\n" + "Mottaget meddelande: " + mottaget);
                    Thread.sleep(1000);
                    anslutning.close();
                } catch (IOException e) {
                    System.err.print(e.toString());

                }
            }
        } catch (InterruptedException exception) {

        }
    }
}
