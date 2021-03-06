package agvg5;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author carli
 */
public class MapPanel1 extends JPanel {

    DataStore1 ds;

    MapPanel1(DataStore1 ds) {
        this.ds = ds;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Color LIGHT_COLOR = new Color(150, 150, 150);
        final Color DARK_COLOR = new Color(0, 0, 0);
        final Color RED_COLOR = new Color(255, 0, 0);
        final Color BLUE_COLOR = new Color(0, 0, 255);
        int x, y;
        int xR, yR;
        int x1, y1, x12, y12;
        int x2, y2, x22, y22;
        int dist;

        final int circlesize = 10;
        final int ysize = 350;
        final int xsize = 700;

        if (ds.networkRead == true) { // Only try to plot is data has been properly read from file

            // Compute scale factor in order to keep the map in proportion when the window is resized
            int height = getHeight();
            int width = getWidth();
            double xscale = 1.0 * width / xsize;
            double yscale = 1.0 * height / ysize;

            g.setColor(RED_COLOR);

            xR = (int) (ds.robotX * xscale);
            yR = (int) (ds.robotY * yscale);

            g.drawOval(xR - ((circlesize + 10) / 2), height - yR - (circlesize + 10) / 2, circlesize + 10, circlesize + 10);

            g.setColor(DARK_COLOR);

            // Draw nodes as circles
            for (int i = 0; i < ds.nodes; i++) {
                x = (int) (ds.nodeX[i] * xscale);
                y = (int) (ds.nodeY[i] * yscale);

                g.fillOval(x - (circlesize / 2), height - y - circlesize / 2, circlesize, circlesize);
            }

            // Draw arcs
            for (int i = 0; i < ds.arcs; i++) {
                g.setColor(BLUE_COLOR);

                if (ds.arcColor[i] == 1) {
                    g.setColor(RED_COLOR);
                }
                x1 = (int) (ds.nodeX[ds.arcStart[i] - 1] * xscale);
                y1 = (int) (ds.nodeY[ds.arcStart[i] - 1] * yscale);
                x2 = (int) (ds.nodeX[ds.arcEnd[i] - 1] * xscale);
                y2 = (int) (ds.nodeY[ds.arcEnd[i] - 1] * yscale);
                g.drawLine(x1, height - y1, x2, height - y2);

                x12 = (int) ds.nodeX[ds.arcStart[i] - 1];
                x22 = (int) ds.nodeX[ds.arcEnd[i] - 1];
                y12 = (int) ds.nodeY[ds.arcStart[i] - 1];
                y22 = (int) ds.nodeY[ds.arcEnd[i] - 1];
                //skriv ut längden på länken
                dist = (int) Math.round(Math.hypot((x12 - x22), (y12 - y22)));
                if (ds.arcColor[i] == 1) {
                    g.drawString(String.valueOf(dist), (x1 + x2) / 2, ((height - y1) + (height - y2)) / 2);

                }

            }
        }
    } // end paintComponent
}
