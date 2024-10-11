package Lec23_Graph_2;


import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;                // Number of vertices
    private int E;                      // Number of edges
    private List<Integer>[] adj;        // Adjacency lists

    /** public Graph(int V): // Create empty graph with v vertices */
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V]; // Array of lists
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();     // Initialize list for each vertex
        }
    }

    /** public void addEdge(int v, int w): // add an edge v-w */
    public void addEdge(int v, int w) {
        adj[v].add(w);   // Add w to v's list
        adj[w].add(v);   // Add v to w's list (since it's an undirected graph)
        E++;             // Increase edge count
    }

    /** Iterable<Integer> adj(int v):      // vertices adjacent to v */
    public Iterable<Integer> adj(int v) {
        return adj[v];   // Return list of adjacent vertices
    }

    /** int V(): // number of vertices */
    public int V() {
        return V;
    }

    /** int E(): // number of edges */
    public int E() {
        return E;
    }

    // degree of vertex v in graph G
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) {
            degree += 1;
        }
        return degree;
    }

    // print the graph
    public static void print(Graph G) {
        for (int v = 0; v < G.V(); v += 1) {
            for (int w : G.adj(v)) {
                System.out.println(v + "-" + w);
            }
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph(5);

        // Adding edges to the graph
        G.addEdge(0, 1);
        G.addEdge(0, 4);
        G.addEdge(1, 4);
        G.addEdge(1, 3);
        G.addEdge(1, 2);
        G.addEdge(3, 2);
        G.addEdge(3, 4);

        // Printing the graph
        System.out.println("Graph:");
        Graph.print(G);

        // Printing degrees of each vertex
        for (int v = 0; v < G.V(); v++) {
            System.out.println("Degree of vertex " + v + ": " + Graph.degree(G, v));
        }
    }
}
