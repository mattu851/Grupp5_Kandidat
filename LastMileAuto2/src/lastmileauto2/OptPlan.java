/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastmileauto2;

import java.util.*;

/**
 *
 * @author Carllindgren
 */
public class OptPlan {

    private List<Vertex> nodes;

    private List<Edge> edges;
    private DataStore ds;

    public OptPlan(DataStore ds) {
        this.ds = ds;
    }

    public void createPlan() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        // Set up network
        for (int i = 0; i < ds.nodes; i++) {
            Vertex location = new Vertex("" + (i + 1), "Nod #" + (i + 1));
            nodes.add(location);
        }
        for (int i = 0; i < ds.arcs; i++) {
            Edge lane = new Edge("" + (i + 1), nodes.get(ds.arcStart[i]
                    - 1), nodes.get(ds.arcEnd[i] - 1), 1);
            // Last argument is arccost 
            edges.add(lane);
        }
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

        // Compute shortest path
        dijkstra.execute(nodes.get(70));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(0));
        // Get shortest path
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i));
        }
        // Arcs in the shortest path
        for (int i = 0; i < path.size() - 1; i++) {
            for (int j = 0; j < ds.arcs; j++) {
                if (ds.arcStart[j] == Integer.parseInt(path.get(i).getId())
                        && ds.arcEnd[j]
                        == Integer.parseInt(path.get(i + 1).getId())) {
                    System.out.println("Arc: " + j);
                    ds.arcColor[j]=1;
                }
            }
        }

    }

}