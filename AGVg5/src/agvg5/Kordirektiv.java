/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agvg5;


import org.apache.commons.lang.ArrayUtils;

public class Kordirektiv implements Runnable {

    private int sleepTime;

    private DataStore1 ds;
    private int qr;
    private OptPlan op;
    private int dir;
    private int[] list; //uppdragslista
    private String currDir;

    public Kordirektiv(int qr_in, OptPlan op, DataStore1 ds) {
        qr = qr_in;
        sleepTime = 1000;
        this.op = op;
        this.ds =ds;
    }

    @Override
    public void run() {
        try {

            list = op.getIndex();

            System.out.println("hej" + list[4]);
            Thread.sleep(sleepTime);

        } catch (InterruptedException exception) {
        }
        //cui.appendStatus("GuiUpdate är nu klar!");
    }

    //Konvertera riktning till nästkommande höger/vänster rakt fram
    public void convertDir() {
        
            
            //förädninger x-led 
            if (ds.nodeX[list[1]]<ds.nodeX[list[2]]) { //kör åt E
                if (currDir=="E"){
                    dir =1;
                }
                else if(currDir=="N"){
                    dir =2;
                }
                else if(currDir=="S"){
                    dir=3;
                }
                currDir= "E";     
            }
            else if(ds.nodeX[list[1]]>ds.nodeX[list[2]]) { //kör åt W
                if (currDir=="W"){
                    dir =1;
                }
                else if(currDir=="N"){
                    dir =3;
                }
                else if(currDir=="S"){
                    dir=2;
                }
                currDir="W";
            }
            else if(ds.nodeY[list[1]]<ds.nodeY[list[2]]){ //N
                if (currDir=="N"){
                    dir =1;
                }
                else if(currDir=="E"){
                    dir =3;
                }
                else if(currDir=="W"){
                    dir=2;
                }
                currDir ="N";
            }
            else{ // S
                 if (currDir=="S"){
                    dir =1;
                }
                else if(currDir=="W"){
                    dir =3;
                }
                else if(currDir=="E"){
                    dir=2;
                }
                currDir ="S";
            }
           list =(int[])ArrayUtils.removeElement(list, 1);
           //Måste lägga till commons-lang-2.6.jar i libraries  - aha

        }
    

    public int getDir() {

        return dir;
    }

}
