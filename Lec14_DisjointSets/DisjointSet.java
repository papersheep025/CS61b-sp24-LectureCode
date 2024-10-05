package Lec14_DisjointSets;

public interface DisjointSet {
    // Connects two items P and Q.
    void connect(int p, int q);

    // Check if two items are connected.
    boolean isConnected(int p, int q);
}
