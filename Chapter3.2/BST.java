import java.util.Queue;
import java.util.LinkedList;
/**
 * Binary Search Trees Class
 */
public class BST<Key extends Comparable<Key>, Value> {
    
    private Node root;
    
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
        
        public Node(Key key, Value val, int n, int h) {
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
    public int heightRec() {
        // Recursive
        return heightRec(root);
    }
    private int heightRec(Node x) {
        if (x == null) return 0;
        int lh = heightRec(x.left);
        int rh = heightRec(x.right);
        if (lh > rh) return lh + 1;
        else         return rh + 1;
    }

    public int height() {
        // Non-recursive
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return 0;
        return x.h;
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

    // Non-recursive get and put
    public Value get2(Key key) {
        Node curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.key);
            if      (cmp < 0) curr = curr.left;
            else if (cmp > 0) curr = curr.right;
            else return curr.val;
        }
        return null;
    }

    public void put2(Key key, Value val) {
        if (root == null) root = new Node(key, val, 1, 1);
        Node curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.key);
            if (cmp < 0) {
                if (curr.left == null) {
                    curr.left = new Node(key, val, 1, 1);
                    return;
                }
                curr = curr.left;
            } else if (cmp > 0) {
                if (curr.right == null) {
                    curr.right = new Node(key, val, 1, 1);
                    return;
                }
                curr = curr.right;
            } else { curr.val = val; }
        }
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
        x.h = Math.max(height(x.right), height(x.left)) + 1;
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
            x.h = Math.max(height(x.right), height(x.left)) + 1;
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
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.n = size(x.left) + size(x.right) + 1;
        x.h = Math.max(height(x.right), height(x.left)) + 1;
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

    /** 
     * Return all of the keys
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue) {
        if (x == null) return;
        keys(x.left, queue);
        queue.add(x.key);
        keys(x.right, queue);
    }

}
