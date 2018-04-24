/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agvg5;

/**
 *
 * @author coolguy_3
 */


public class platsattaka {
    
    DataStore1 ds;
    
   platsattaka(DataStore1 ds){
        this.ds=ds;
        
    }
    
    Http_1 http;
    OptPlan op;
  
    String platser,getMessage,lista,test;
    int antalplatser,start,dest;
    String[] split1;
    
    public void aka(){
    http = new Http_1();
    
    op = new OptPlan(ds);
    
    lista="http://tnk111.n7.se/listaplatser.php";
    getMessage="http://tnk111.n7.se/getmessage.php?messagetype=2";
    
    platser=http.Http_1(lista);
    
    System.out.println(platser);
    
    antalplatser = Integer.parseInt(platser.substring(0,1));
    
    test=platser.substring(1);
    
    split1=test.split("(?=\\p{Upper})");
  
    start=0; // Bör vara vart bilen befinner sig
    String dummy,dummy1;
   String[] testd;
   int stordum;
       
    for (int i=0; i < antalplatser;i++){
        dummy=split1[i].substring(2);
        dummy1=dummy.replace(","," ");
        testd=dummy1.split(" ");
        
        for(int j=0; j<2;j++){
        op.createPlan(start, Integer.parseInt(testd[j]));
        stordum=op.getCost();
        System.out.println("testarstor"+stordum);
        }
    }
        
   
  
   
     
    
    
    
    
    
    
       
        
    
       
           
            
}
    
    
}



