package Lec21_PriorityQueues;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeapPQ<Item extends Comparable<Item>> implements MinPQ<Item> {
    private ArrayList<Item> heap;

    public MinHeapPQ() {
        heap = new ArrayList<>();
    }

    @Override
    public void add(Item x) {
        heap.add(x);
        swim(heap.size() - 1);
    }

    @Override
    public Item getSmallest() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }
        return heap.get(0);
    }

    @Override
    public Item removeSmallest() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }
        Item smallest = heap.get(0);
        int lastIndex = heap.size() - 1;
        swap(0, lastIndex);
        heap.remove(lastIndex);
        sink(0);
        return smallest;
    }

    @Override
    public int size() {
        return heap.size();
    }

    // Helper methods for heap operations
    private void swim(int k) {
        while (k > 0 && greater(parent(k), k)) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    private void sink(int k) {
        while (leftChild(k) < heap.size()) {
            int smallerChild = leftChild(k);
            if (rightChild(k) < heap.size() && greater(smallerChild, rightChild(k))) {
                smallerChild = rightChild(k);
            }
            if (!greater(k, smallerChild)) {
                break;
            }
            swap(k, smallerChild);
            k = smallerChild;
        }
    }

    private boolean greater(int i, int j) {
        return heap.get(i).compareTo(heap.get(j)) > 0;
    }

    private void swap(int i, int j) {
        Item temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int parent(int k) {
        return (k - 1) / 2;
    }

    private int leftChild(int k) {
        return 2 * k + 1;
    }

    private int rightChild(int k) {
        return 2 * k + 2;
    }
}

