package Lec18_RedBlackTrees;

public class RotatingTrees<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;              // key
        Value val;            // associated data
        Node left, right;     // links to left and right subtrees
        boolean color;        // color of parent link

        Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    private Node root;  // root of the tree

    // Rotate right (counter-clockwise rotation) to balance the tree
    private Node rotateRight(Node h) {
        // assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // Rotate left (clockwise rotation) to balance the tree
    private Node rotateLeft(Node h) {
        // assert (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // Flip colors to ensure correct tree coloring
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    // Check if the node is red
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    // Insert a key-value pair into the tree
    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;  // Root must always be black
    }

    // Recursive insertion method
    private Node put(Node h, Key key, Value val) {
        if (h == null) { return new Node(key, val, RED); }  // Insert new node

        int cmp = key.compareTo(h.key);
        if (cmp < 0)      { h.left  = put(h.left,  key, val); }  // Insert in left subtree
        else if (cmp > 0) { h.right = put(h.right, key, val); }  // Insert in right subtree
        else              { h.val   = val;                    }  // Update value if key already exists

        // Perform rotations and color flips to maintain red-black tree properties
        if (isRed(h.right) && !isRed(h.left))      { h = rotateLeft(h);  }
        if (isRed(h.left)  &&  isRed(h.left.left)) { h = rotateRight(h); }
        if (isRed(h.left)  &&  isRed(h.right))     { flipColors(h);      }

        return h;
    }

    // Main method for testing
    public static void main(String[] args) {
        RotatingTrees<Integer, String> tree = new RotatingTrees<>();

        tree.put(1, "one");
        tree.put(2, "two");
        tree.put(3, "three");
        tree.put(4, "four");
        tree.put(5, "five");

        System.out.println("Insertions complete");
    }
}

/*
public class RotatingTrees {

    private Node rotateRight(Node h) {
        // assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    // make a right-leaning link lean to the left
    private Node rotateLeft(Node h) {
        // assert (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) { return new Node(key, val, RED); }

        int cmp = key.compareTo(h.key);
        if (cmp < 0)      { h.left  = put(h.left,  key, val); }
        else if (cmp > 0) { h.right = put(h.right, key, val); }
        else              { h.val   = val;                    }

        if (isRed(h.right) && !isRed(h.left))      { h = rotateLeft(h);  }
        if (isRed(h.left)  &&  isRed(h.left.left)) { h = rotateRight(h); }
        if (isRed(h.left)  &&  isRed(h.right))     { flipColors(h);      }

        return h;
    }
}
 */
