package lec12_inheritance_4;

import java.util.Iterator;

public class MyArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public MyArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    // Add an item.
    public void add(T x) {
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    // Returns true if this set contains the specified item.
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    // Return a new iterator.
    public Iterator<T> iterator() {
        return new MyArraySet.ArraySetIterator();
    }

    // toString method.
    @Override
    public String toString() {
        StringBuilder x = new StringBuilder();
        x.append("(");
        for (T i : this) {
            x.append(i.toString());
            x.append(" ");
        }
        x.append(")");
        return x.toString();
    }

    @Override
    public boolean equals(Object o) {
        // Check if o is an array set.
        if (o instanceof MyArraySet otherArraySet) {
            if (this.size != otherArraySet.size) {
                return false;
            }
            for (T i : this) {
                if (!otherArraySet.contains(i)) {
                    return false;
                }
            }
            return true;
        }
        // o is not an array set.
        return false;
    }

    /**
     * Add an iterator() method to your class that returns an Iterator<T>.
     * The Iterator<T> returned should have a useful hasNext() and next() method.
     * Add implements Iterable<T> to the line defining your class.
     */
    // In order to use for (int i : S), we need class ArraySetIterator!
    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    public static void main(String[] args) {
        ArraySet<Integer> S = new ArraySet<>();
        S.add(5);
        S.add(23);
        S.add(90);

        System.out.println(S.contains(90));
        System.out.println(S.contains(42));

        // Using string builder, we can directly write println(S)!
        System.out.println(S);

        // Nice iteration!
        for (int i : S) {
            System.out.println(i);
        }
    }
}
