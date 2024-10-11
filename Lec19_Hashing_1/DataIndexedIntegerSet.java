package Lec19_Hashing_1;

public class DataIndexedIntegerSet {
    private boolean[] present;
    public int i;

    public DataIndexedIntegerSet() {
        present = new boolean[2000000000];
    }

    public void add(int x) {
        present[i] = true;
    }

    public boolean contains(int x) {
        return present[i];
    }

    public static int asciiToInt(String s) {
        int intRep = 0;
        for (int i = 0; i < s.length(); i += 1) {
            intRep = intRep * 126;
            intRep = intRep + s.charAt(i);
        }
        return intRep;
    }

    public static void main(String[] args) {
        System.out.println("瓶子君152".hashCode());
    }
}
