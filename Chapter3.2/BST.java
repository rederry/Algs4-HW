
/**
 * Binary Search Trees Class
 */
public class BST<Key extends Comparable<Key>, Value> {
    
    Node root;
    
    /**
     * Nested class Node present the nodes in BST
     */
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        // The count of node in subtree rooted here
        private int n;
        // The height from this node
        private int h;
        
        public Node(Key key, Value value, int n, int h) {
            this.key = key;
            this.val = val;
            this.n = n;
            this.h = h;
        }
    }
    
    /**
     * The size of this BST
     * @return the int size
     */
    public int size() {
        return size(root);
    }
    
    /**
     * The size of the subtree of explicit node 
     * @param: the node in this BST
     * @return number of nodes in subtree rooted here
     */
    private int size(Node x) {
        if (x == null) return 0;
        return x.n;
    }

    /**
     * 3.2.6
     * @return height of the tree
     */
    public int height() {
        // Recursive
        return height(root);
    }
    public int height2() {
        // Non-recursive
        if (root == null) return 0;
        return root.h;
    }

    private int height(Node x) {
        if (x == null) return 0;
        int lh = height(x.left);
        int rh = height(x.right);
        if (lh > rh) return lh + 1;
        else         return rh + 1;
    }


    /**
     * The value of the given key
     * @param: key for search
     * @return the value of the key, if not found return null
     */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    /**
     * Insert the new value into tree
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.n = size(x.right) + size(x.left) + 1;
        x.h = Math.max(x.right.h, x.left.h) + 1;
        return x;
    }

    /**
     * Delete the minimum node
     */
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x == null) return null;
        if (x.left != null) {
            x.left = deleteMin(x.left);
            x.n = size(x.left) + size(x.right) + 1;
            x.h = Math.max(x.right.h, x.left.h) + 1;
            return x;
        } else {
            return x.right;
        }
    }

    /**
     * Delete a specific node
     * @param key to delete
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(x.right);
            x.left = t.left;
            x.right = deleteMin(t.right);
        }
        x.n = size(x.left) + size(x.right) + 1;
        x.h = Math.max(x.right.h, x.left.h) + 1;
        return x;
    }
    
    /**
     * Return the max Key of the tree
     */
    public Key max() { return max(root).key; }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }
    
    /**
     * Return the min key of the tree
     */
    public Key min() { return min(root).key; }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        return x == null ? null : x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return floor(x.left, key);
        else if (cmp > 0) {
            Node t = floor(x.right, key);
            return t == null ? x : t;
        }
        else return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        return x == null ? null : x.key;
    }
    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return ceiling(x.right, key);
        else if (cmp < 0) {
            Node t = ceiling(x.left, key);
            return t == null ? x : t;
        }
        else return x;
    }

    /**
     * Return the kth smallest key
     */
    public Key select(int k) {
        return select(root, k);
    }

    private Key select(Node x, int k) {
        if (x == null) return null;
        int lsize = size(x.left);
        if (lsize <  k) return select(x.right, k - lsize - 1);
        if (lsize >  k) return select(x.left, k);
        return x.key;
    }


}
