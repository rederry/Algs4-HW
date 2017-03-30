import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Steque<Item> {

    private Node first;
    private int n;
    private Node last;
    
    class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push (Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (isEmpty()) last = first;
        n++;
    }

    public Item pop() {
        if (isEmpty()) return null;
        n--;
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = first;
        return item;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        n++;
    }

    @Override
    public String toString() {
        String s = "";
        Node curr = first;
        while (curr != null) {
            s = s + curr.item + "->";
            curr = curr.next;
        }
        return s + "null";
    }

    public static void main(String[] args) {
        Steque<String> sq = new Steque<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            sq.push(s);
        }
        sq.pop();
        sq.pop();
        sq.pop();
        sq.enqueue("enqueue");
        sq.pop();
        sq.enqueue("Test success");
        StdOut.println(sq);
    }
}
