package Lec16_ADTs_BSTs;

public class BinarySearch {
    public static int binarySearch(String[] sorted, String x, int lo, int hi) {
        if (lo > hi) { // If the lower index exceeds the upper index, the search range is invalid.
            return -1;
        }

        int m = (lo + hi) / 2;
        int cmp = x.compareTo(sorted[m]); // Compares x with the middle element sorted[m].

        if (cmp < 0) { // x < sorted[m]
            return binarySearch(sorted, x, lo, m - 1);
        } else if (cmp > 0) { // x > sorted[m]
            return binarySearch(sorted, x,m + 1, hi);
        } else return m; // x = sorted[m], so it returns m.
    }
}
