package Lec22_Graph_1;


public class Orders {
    private static class BSTNode {
        int key;
        BSTNode left, right;

        public BSTNode(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root node of the tree
    BSTNode root;

    // Constructor to initialize an empty tree
    public Orders() {
        root = null;
    }

    // Method to insert a new key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive insert function
    private BSTNode insertRec(BSTNode root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }

        // Otherwise, recurse down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    /** Pre-order traversal
     *     preOrder(BSTNode x) {
     *         if (x == null) return;
     *         print(x.key)
     *         preOrder(x.left)
     *         preOrder(x.right)
     *     }
     */
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(BSTNode x) {
        if (x == null) return;

        System.out.print(x.key + " "); // Visit the node
        preOrderRec(x.left);           // Traverse the left subtree
        preOrderRec(x.right);          // Traverse the right subtree
    }

    /** In-order traversal
     *     inOrder(BSTNode x) {
     *         if (x == null) return;
     *         inOrder(x.left)
     *         print(x.key)
     *         inOrder(x.right)
     *     }
     */
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode node) {
        if (node == null) return;

        inOrderRec(node.left);            // Traverse the left subtree
        System.out.print(node.key + " "); // Visit the node
        inOrderRec(node.right);           // Traverse the right subtree
    }

    /** Post-order traversal
     *     postOrder(BSTNode x) {
     *         if (x == null) return;
     *         postOrder(x.left)
     *         postOrder(x.right)
     *         print(x.key)
     *     }
     */
    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(BSTNode node) {
        if (node == null) return;

        postOrderRec(node.left);          // Traverse the left subtree
        postOrderRec(node.right);         // Traverse the right subtree
        System.out.print(node.key + " "); // Visit the node
    }

    public static void main(String[] args) {
        Orders tree = new Orders();

        // Insert nodes into the tree
//        tree.insert(50);
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(40);
//        tree.insert(70);
//        tree.insert(60);
//        tree.insert(80);

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        System.out.println("Pre-order traversal:");
        tree.preOrder();
        System.out.println("\nIn-order traversal:");
        tree.inOrder();
        System.out.println("\nPost-order traversal:");
        tree.postOrder();
    }

}





