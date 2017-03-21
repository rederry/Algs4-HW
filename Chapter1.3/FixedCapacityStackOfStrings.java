import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Class: the stack of string class with fixed capacity
 */
public class FixedCapacityStackOfStrings {
    // the capacity
    private int capacity;
    // size of current stack
    private int n;
    // string array
    private String[] a;
    
    /**
     * Constructor of stack, initialize a new stack
     * @param capacity
     */
    public FixedCapacityStackOfStrings(int capacity) {
        n = 0;
        this.capacity = capacity;
        a = new String[capacity];
    }
    
    /**
     * Is this stack empty
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Is this stack full
     * @return true if this stack is full; false otherwise
     */
    public boolean isFull() {
        return n == capacity;
    }
    
    /**
     * Returns size of current stack
     * @return size of current stack
     */
    public int size() {
        return n;
    }
    
    /**
     * Pop the last string in array
     * @return the last string
     * @throw NoSuchElementException
     */
    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("stack is empty");
        return a[--n];
    }
    
    /**
     * Push new string to stack
     */
    public void push(String str) {
        if (isFull()) throw new NoSuchElementException("stack is full");
        a[n++] = str;
    }
    
    public static void main(String[] args) {
        FixedCapacityStackOfStrings fs = new FixedCapacityStackOfStrings(10);
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (!str.equals("-")) {
                fs.push(str);
            }else {
                StdOut.println(fs.pop() + " ");
            }
        }
        StdOut.println("(" + fs.size() + " left on stack)");
    }
}