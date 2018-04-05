/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agvg5;

public class AGVg5 {

    //ControlUI2 cui;
    BluetoothTransmitter bt;
    BluetoothReceiver br;
    DataStore1 ds;
    GUI gui;

    /**
     * @param args the command line arguments
     */
    AGVg5() {

        String Bn;
        String Cn;

        //Lab3 dator
        //Bn = "001A7DDA7106";
        //Cn = "1";
        //Rasberry
        Bn = "B827EB003082";
        Cn = "22";

        // Grupp 4
        //Bn ="001060D1C8E1";	
        //Cn =1;
        bt = new BluetoothTransmitter(Bn, Cn);
        br = new BluetoothReceiver();
        ds = new DataStore1();
       

        ds.setFileName("/home/itn/NetBeansProjects/Grupp5_Kandidat/streets.txt");
        ds.readNet();
        gui = new GUI(ds);

        gui.setVisible(true);
        gui.changeChannel(Cn);
        gui.changeAdress(Bn);

        //Test för att ändra uppdragslistan.
        int i = 0;
        while (i <= 40) {
            gui.setUppdrag("" + Cn + i);
            i++;
        }

        //cui=new ControlUI2(bt);
        // cui.setVisible(true);
        Thread t1 = new Thread(bt);
        Thread t2 = new Thread(br);
        //Thread t3 = new Thread(gui);

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        // TODO code application logic here

        AGVg5 x = new AGVg5();

    }

}
