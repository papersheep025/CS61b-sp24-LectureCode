package Lec16_ADTs_BSTs;

public class ADT {
    private class BST<Key> {
        private Key key;
        private BST left;
        private BST right;

        public BST(Key key, BST left, BST Right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public BST(Key key) {
            this.key = key;
        }
    }
}

/*
    public static <Key> BST find(BST T, Key sk) {
        if (T == null) return null;
        if (sk.equals(T.key)) {
            return T;
        } else if (sk < T.key) {
            return find(T.left, sk);
        } else {
            return find(T.right, sk);
        }
    }

    static <Key> BST insert(BST T, Key ik) {
        if (T == null) {
            return new BST(ik);
        }
        if (ik ≺ T.key) {
            T.left = insert(T.left, ik);
        } else if (ik ≻ T.key){
            T.right = insert(T.right, ik);
            return T;
        }
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
*/
