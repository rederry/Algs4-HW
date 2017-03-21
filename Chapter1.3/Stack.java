import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> {
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
    
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.item;
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
    }
}