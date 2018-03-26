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
    
    /**
     * @param args the command
     * line arguments
     */
    
    
     AGVg5(){
      
   
    String Bn = "001A7DDA7106";
    String Cn = "1";
    
    
    Bn = "B827EB003082";
    Cn = "22";     
    
    
        bt = new BluetoothTransmitter(Bn, Cn);
        br = new BluetoothReceiver();
       //cui=new ControlUI2(bt);
       // cui.setVisible(true);
        
        Thread t1 = new Thread(bt);
        Thread t2 = new Thread(br);
         
        t1.start();
        t2.start();
    }
    public static void main(String[] args) {
        // TODO code application logic here
          
        AGVg5 x= new AGVg5();
     
        
        
    }
    
}