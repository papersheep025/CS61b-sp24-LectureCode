package Lec14_DisjointSets;

public class QuickUnionDS implements DisjointSet{
    private int[] parent;

    public QuickUnionDS(int num) {
        parent = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = -1;
        }
    }

    // Find root.
    private int find(int p) {
        while (parent[p] >= 0) {
            p = parent[p];
        }
        return p;
    }

    // Connect two items.
    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j = find(q);
        parent[i] = j;
    }

    // Return true if two items share the same root.
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
