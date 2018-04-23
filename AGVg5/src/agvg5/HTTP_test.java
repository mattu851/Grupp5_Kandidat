package agvg5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author itn
 */
public class HTTP_test implements Runnable {

    private String url;

    public HTTP_test(String URL) {
        url = URL;

    }

    public void run() {
        try {
               while (true) {
            URL urlobjekt = new URL(url);
            HttpURLConnection anslutning = (HttpURLConnection) urlobjekt.openConnection();
            System.out.println("\nAnropar: " + url);
            int mottagen_status = anslutning.getResponseCode();
            System.out.println("Statuskod: " + mottagen_status);

            BufferedReader inkommande = new BufferedReader(new InputStreamReader(anslutning.getInputStream()));
            String inkommande_text = "";
            StringBuffer inkommande_samlat = new StringBuffer();
           
         

                while ((inkommande_text = inkommande.readLine()) != null) {
                    inkommande_samlat.append(inkommande_text);
                }

                System.out.println(inkommande_samlat.toString());
                Thread.sleep(2000);
                inkommande.close();
                
            }

           
            //System.out.println(inkommande_samlat.toString());

            //Thread.sleep(1000);
        } catch (Exception e) {
            System.out.print(e.toString());
        }

    }

}
