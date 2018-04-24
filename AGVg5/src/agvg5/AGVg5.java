/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// 0=stanna 1=höger 2=vänster 
package agvg5;

public class AGVg5 {

    //ControlUI2 cui;
    BluetoothTransmitter bt;
    BluetoothReceiver br;
    DataStore1 ds;
    GUI gui;
    HTTP_test http;
    Kordirektiv kd;
    BluetoothTransceiver blue;
    Http_1 httptest;
    platsattaka korabil;


    /**
     * @param args the command line arguments
     */
    AGVg5() {

        String Bn;
        String Cn;
        String testar;
        //Lab3 dator
        //Bn = "001A7DDA7106";
        //Cn = "1";
        //Rasberry
        Bn = "B827EB003082";
        Cn = "22";

        // Grupp 4
        //Bn ="001060D1C8E1";	
        //Cn =1;
        // bt = new BluetoothTransmitter(Bn, Cn);
        //  br = new BluetoothReceiver();
        ds = new DataStore1();

     

       // blue = new BluetoothTransceiver();

        //Ubuntu-dator

        ds.setFileName("/home/itn/NetBeansProjects/Grupp5_Kandidat/streets_new.txt");

        //ds.setFileName("/home/itn/NetBeansProjects/Grupp5_Kandidat/streets.txt");

        // Gustavs dator
      //   ds.setFileName("C:/Users/Gustav/Documents/GitHub/Grupp5_Kandidat/real_streets.txt");
        // Calles dator

        //ds.setFileName("/Users/Carllindgren/Documents/Kandidat/Grupp5_Kandidat/streets.txt");






        //http = new HTTP_test("http://tnk111.n7.se/listaplatser.php");
        
        //String plats = "http://tnk111.n7.se/listauppdrag.php?plats=A";
       /*  
        String plats = "http://tnk111.n7.se/listauppdrag.php?plats=";
        http = new HTTP_test(plats + get.ABC);
        Där get.ABC är en metod från den klass som tar beslutet vart AGVn ska åka
       */
        //http = new HTTP_test(plats);

        ds.readNet();

        gui = new GUI(ds);

        gui.setVisible(true);

        gui.changeChannel(Cn);
        gui.changeAdress(Bn);
        //System.out.println(blue.get_QR());
        //blue.get_QR();

        //cui=new ControlUI2(bt);
        // cui.setVisible(true);
        //Thread t1 = new Thread(bt);
        //Thread t2 = new Thread(br);
        //Thread t3 = new Thread(gui);
        //Thread t4 = new Thread(http);
        korabil = new platsattaka(ds);
        
        korabil.aka();
        
      // Test så att Http_1 fukar
      /*
      String plats = "http://tnk111.n7.se/listauppdrag.php?plats=A";
      httptest = new Http_1();
      httptest.Http_1(plats);
      */
        //t1.start();
        //t2.start();
        //t4.start();
        
        
        
        

    }

    public static void main(String[] args) {
        // TODO code application logic here

        AGVg5 x = new AGVg5();

    }

}
