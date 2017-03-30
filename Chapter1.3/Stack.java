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
        Node() {
            item = null;
            next = null;
        }
        Node(Node x) {
            item = x.item;
            if (x.next != null) next = new Node(x.next);
            else next = null;
        }
    }

    public Stack() {
        first = null;
        n = 0;
    }
    
    /**
     * Exercises 1.3.42
     * Copy constructor
     */
    public Stack(Stack<Item> s) {
        first = new Node(s.first);
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

    public void clear() {
        Node p = first;
        while (p != null) {
            p.item = null;
            p = p.next;
        }
        first = null;
    }

    @Override
    public String toString() {
        String s = "";
        for (Item item : this) {
            s += item + "->";
        }
        return s + "null";
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
        StdOut.println(s);
        Stack<String> cp1 = Stack.copy(s);
        StdOut.println(cp1);
        Stack<String> cp2 = new Stack<String>(s);
        StdOut.println(cp2);

        StdOut.println("Empty the origin stack");
        s.clear();
        
        StdOut.println(s);
        StdOut.println(cp1);
        StdOut.println(cp2);

    }
}
