package Lec23_Graph_2;


public class Graph {
/**
    public Graph(int V):               // Create empty graph with v vertices

    public void addEdge(int v, int w): // add an edge v-w

    Iterable<Integer> adj(int v):      // vertices adjacent to v

    int V():                           // number of vertices

    int E():                           // number of edges


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
*/
}
