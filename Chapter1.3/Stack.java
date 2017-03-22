import java.util.NoSuchElementException;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item>{
    private Node first;
    private int n;
    
    private class Node {
        Item item;
        Node next;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return n;
    }
    
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.next = oldfirst;
        first.item = item;
        n++;
    }
    
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }
    
    /**
     * Exercises 1.3.7
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.item;
    }
    
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {}
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    /**
     * Exercises 1.3.12
     * Copy
     * Takes a stack of strings as argument and returns a copy of the stack.
     */
    public static Stack<String> copy(Stack<String> ss) {
        Stack<String> cp1 = new Stack<String>();
        Stack<String> cp2 = new Stack<String>();
        for (String item : ss) {
            cp1.push(item);
        }
        for (String item : cp1) {
            cp2.push(item);
        }
        return cp2;
    }
    
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (!str.equals("-")) {
                s.push(str);
            }else {
                StdOut.println(s.pop() + " ");
            }
        }
        for (String x : Stack.copy(s)) StdOut.println(x);
    }
}