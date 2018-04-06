package lastmileauto2;

/**
 *
 * @author clary35
 */
public class LastMileAuto {

    DataStore ds;
    ControlUI cui;
    OptPlan op;

    LastMileAuto() {

        /*
         * Initialize the DataStore call where all "global" data will be stored
         */
        ds = new DataStore();

        /*
         * This sets the file path and read network text file. Adjust for your needs.
         */

        //Ubuntu-dator
        //ds.setFileName("/home/itn/NetBeansProjects/Grupp5_Kandidat/streets.txt");
        // Gustavs dator
        ds.setFileName("C:/Users/Gustav/Documents/GitHub/Grupp5_Kandidat/streets.txt");
        // Calles dator
        //ds.setFileName("/Users/Carllindgren/Documents/Kandidat/Grupp5_Kandidat/streets.txt");

        
        ds.readNet();

        /*
         * Initialize and show the GUI. The constructor gets access to the DataStore
         */
        cui = new ControlUI(ds);
        cui.setVisible(true);
        cui.showStatus();
        
        OptPlan op = new OptPlan(ds);
        op.createPlan();

        GuiUpdate g1 = new GuiUpdate(ds, cui, op);
        Thread t2 = new Thread(g1);

        t2.start();

        

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* This is the "main" method what gets called when the application starts
         * All that is done here is to make an instance of the RobotControl class,
         * and thereby, call the RobotControl constructor.
         */
        LastMileAuto x = new LastMileAuto();

    }
}
