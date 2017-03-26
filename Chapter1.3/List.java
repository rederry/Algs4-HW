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
     * E1319 
     * Remove the last one node
     */
    public void removeLast() {
        if (first == null) return;
        if (first.next == null) {
            first = null;
            return;
        }
        Node curr = first;
        while (curr.next.next != null)
            curr = curr.next;
        curr.next = null;
    }

    /**
     * E1320
     */
    public void delete(int k) {
        if (k > n || k <= 0) return;
        if (k == 1) {
            first = first.next;
            return;
        }
        --k; 
        Node curr = first;
        while (k-- != 1)
            curr = curr.next;
        curr.next = curr.next.next;
    }

    /**
     * E1321 Find
     */
    public boolean find(Item key) {
        Node curr = first;
        while (curr != null) {
            if (curr.item.equals(key))
                return true;
            curr = curr.next;
        }
        return false;
    }

    /**
     * E1324
     */
    public void removeAfter(Node n) {
        Node curr = first;
        while (curr != null) {
            if (curr.item.equals(n.item) && curr.next != null) {
                curr.next = curr.next.next;
                break;
            }
        }
    }

    /**
     * E1325
     */
    public void insertAfter(Node n1, Node n2) {
        if (!find(n1.item)) return;
        Node curr = first;
        while (curr != null) {
            if (curr.item.equals(n1.item)){
                n2.next = curr.next;
                curr.next = n2;
            }
        }
    }

    /**
     * E1326
     */
    public void remove(Item key) {
        Node curr = first;
        while (curr != null) {
            if (curr.next != null && curr.next.item.equals(key))
                curr.next = curr.next.next;
            curr = curr.next;
        }
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
        List<String> l = new List<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            l.add(s);
        }
        StdOut.println(l.find("kakak"));
        StdOut.println(l.find("a"));
    }
}
