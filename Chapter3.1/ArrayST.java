
public class ArrayST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int size;
    private int capacity;

    public ArrayST(int capacity) {
        keys = (Key[]) new Object[capacity];
        vals = (Value[]) new Object[capacity];
        size = 0;
    }

    public void put(Key key, Value val) {
        //if (size == capacity) resizeArray(2 * capacity);
        keys[size] = key;
        vals[size] = val;
        size++;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int r = rank(key);
        if (keys[r].compareTo(key) == 0) return vals[r];
        return null;
    }

    public void delete(Key key) {
        if (isEmpty()) return;
        int r = rank(key);
        if (keys[r].compareTo(key) != 0) return;
        swap(keys, r, size-1);
        swap(vals, r, size-1);
        keys[size-1] = null;
        vals[size-1] = null;
        size--;
    }

    private void swap(Object[]a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public boolean contains(Key key) {
        if (isEmpty()) return false;
        int r = rank(key);
        return keys[r].compareTo(key) == 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Key min() {
        if (isEmpty()) return null;
        int min = 0;
        for (int i = 0; i < size; i++) {
            if (keys[i].compareTo(keys[min]) < 0)
                    min = i;
        }
        return keys[min];
    }

    public Key max() {
        if (isEmpty()) return null;
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (keys[i].compareTo(keys[max]) > 0)
                    max = i;
        }
        return keys[max];
    }

    public Key floor(Key key) {
        if (isEmpty()) return null;
        int f = 0;
        for (int i = 0; i < size; i++) {
            if (keys[i].compareTo(key) == 0) return keys[i]; 
            if (keys[i].compareTo(key) < 0 && keys[i].compareTo(keys[f]) > 0) f = i;
        }
        if (f == 0 && keys[f].compareTo(key) > 0) return null;
        return keys[f];
    }

    public Key ceiling(Key key) {
        if (isEmpty()) return null;
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (keys[i].compareTo(key) == 0) return keys[i]; 
            if (keys[i].compareTo(key) > 0 && keys[i].compareTo(keys[c]) < 0) c = i;
        }
        if (c == 0 && keys[c].compareTo(key) < 0) return null;
        return keys[c];
    }

    public int rank(Key key) {
        int r = 0;
        for (int i = 0; i < size; i++) {
            if (keys[i].compareTo(key) < 0)
                r++;
        }
        return r;
    }

    public Key select(int k) {
        return null;
    }

    public int size(Key lo, Key hi) {
        return 0;
    }

    public Iterable<Key> keys() {
        return null;
    }

}
