import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class List<Item> {

    private Node first;
    private int n;
    
    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * E1320
     */
    public void delete(int k) {
        --k; 
        Node curr = first;
        while (k != 0) {
            curr = curr.next;
            k--;
        }
        curr = curr.next;
    }

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
        List<String> l = new List<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            l.add(s);
        }
        StdOut.println(l);
        l.delete(3);
        StdOut.println(l);
    }
}
