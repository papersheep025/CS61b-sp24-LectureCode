package Lec23_Graph_2;

import java.util.Stack;

public class Paths {
    private boolean[] marked;     // marked[v] = is there an s-v path?
    private int[] edgeTo;         // edgeTo[v] = last vertex on s-v path
    private final int s;          // source vertex

    /** public Paths(Graph G, int s):    // Find all paths from G */
    // Constructor: Find all paths from source vertex `s` in Graph `G`
    public Paths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);  // Start depth-first search from the source vertex `s`
    }

    // Depth-first search (DFS) from vertex v
    private void dfs(Graph G, int v) {
        marked[v] = true;  // Mark the vertex as visited
        for (int w : G.adj(v)) {  // For every adjacent vertex to `v`
            if (!marked[w]) {     // If it hasn't been visited, explore it
                edgeTo[w] = v;    // Remember the path (v -> w)
                dfs(G, w);        // Recursively explore from w
            }
        }
    }

    /** boolean hasPathTo(int v):        // is there a path from s to v */
    public boolean hasPathTo(int v) {
        return marked[v];  // If marked[v] is true, there's a path to v
    }

    /** Iterable<Integer> pathTo(int v): // path from s to v (if any) */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;  // No path if v isn't reachable
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);   // Push vertices onto the stack as we backtrack
        }
        path.push(s);  // Finally, add the source vertex
        return path;   // Return the path as an iterable (LIFO order)
    }

    public static void main(String[] args) {
        Graph G = new Graph(6);

        // Adding edges to the graph
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 5);
        G.addEdge(1, 3);
        G.addEdge(2, 4);
        G.addEdge(3, 4);
        G.addEdge(3, 5);
        G.addEdge(4, 5);

        // Find paths from source vertex 0
        Paths paths = new Paths(G, 0);

        // Print paths from source vertex 0 to all other vertices
        for (int v = 0; v < G.V(); v++) {
            if (paths.hasPathTo(v)) {
                System.out.print("Path from 0 to " + v + ": ");
                for (int x : paths.pathTo(v)) {
                    if (x == 0) System.out.print(x);
                    else System.out.print(" -> " + x);
                }
                System.out.println();
            } else {
                System.out.println("No path from 0 to " + v);
            }
        }
    }
}