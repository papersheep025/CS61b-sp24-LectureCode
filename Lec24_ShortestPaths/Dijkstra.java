package Lec24_ShortestPaths;

import java.util.*;

public class Dijkstra {
    /**
     * Pseudocode:
     * def Dijkstra(source):
     *     PQ.add(source, 0)
     *     For all other vertices, v, PQ.add(v, infinity)
     *     while PQ is not empty:
     *         p = PQ.removeSmallest()
     *         relax(all edges from p)
     *
     * def relax(edge p,q):
     *    if q is visited (i.e., q is not in PQ):
     *        return
     *
     *    if distTo[p] + weight(edge) < distTo[q]:
     *        distTo[q] = distTo[p] + w
     *        edgeTo[q] = p
     *        PQ.changePriority(q, distTo[q])
     */

    private static class Edge {
        int target;  // Target vertex
        int weight;  // Weight of the edge

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    private static class Graph {
        private final List<List<Edge>> adjacencyList;  // Adjacency list

        Graph(int vertices) {
            adjacencyList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        void addEdge(int source, int target, int weight) {
            adjacencyList.get(source).add(new Edge(target, weight));  // Add edge
        }

        void dijkstra(int source) {
            int[] distTo = new int[adjacencyList.size()];  // Store shortest distances to each vertex
            Arrays.fill(distTo, Integer.MAX_VALUE);  // Initialize to infinity
            distTo[source] = 0;  // Distance to the source is 0

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> distTo[a]));  // Priority queue
            pq.add(source);  // Add the source vertex to the priority queue

            while (!pq.isEmpty()) {
                int p = pq.poll();  // Remove the vertex with the smallest distance from the queue

                // Relax all edges from vertex p
                for (Edge edge : adjacencyList.get(p)) {
                    relax(p, edge.target, edge.weight, distTo, pq);  // Call the relax method
                }
            }

            printDistances(distTo, source);  // Print final distances
        }

        private void relax(int p, int q, int weight, int[] distTo, PriorityQueue<Integer> pq) {
            // If the path through p to q is shorter, update q's distance
            if (distTo[p] + weight < distTo[q]) {
                distTo[q] = distTo[p] + weight;

                // If q is not already in the priority queue, add it
                if (!pq.contains(q)) {
                    pq.add(q);
                }
            }
        }

        private void printDistances(int[] distTo, int source) {
            System.out.println("Distances from source vertex " + source + ":");
            for (int i = 0; i < distTo.length; i++) {
                System.out.println("Vertex " + i + ": " + (distTo[i] == Integer.MAX_VALUE ? "Infinity" : distTo[i]));
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);  // Create a graph with 5 vertices
        graph.addEdge(0, 1, 10);  // Add edges
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 1, 4);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 3, 9);

        int source = 0;  // Set the source vertex
        graph.dijkstra(source);  // Execute Dijkstra's algorithm
    }
}

