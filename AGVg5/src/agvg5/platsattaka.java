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
    
    Http_1 http;
    OptPlan op;
    DataStore1 ds;

    String platser,getMessage,lista,test;
    int antalplatser;
    String[] split;
    
    public void aka(){
    http = new Http_1();
    ds = new DataStore1();
    op = new OptPlan(ds);
    lista="http://tnk111.n7.se/listaplatser.php";
    getMessage="http://tnk111.n7.se/getmessage.php?messagetype=2";
    
    platser=http.Http_1(lista);
    
    System.out.println(platser);
    
    antalplatser = Integer.parseInt(platser.substring(0,1));
    
    test=platser.substring(1);
     
    split=test.split(";", 10);
    
    
        System.out.println(split[2]);
       
           
            
}
    
    
}



