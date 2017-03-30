

public class Deque<Item> {
    
    private Node first;
    private Node last;
    private int n;
    
    private class Node {
        Item item;
        Node next;
        Node pre;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void pushLeft(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
            last = first;
        } else {
            first.next = oldfirst;
            oldfirst.pre = first;
        }
        n++;
    }

    public void pushRight(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
            last.pre = oldlast;
        }
        n++;
    }

    public Item popLeft() {
        if (isEmpty()) return null;
        n--;
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = first;
        else first.pre = null;
        return item;
    }

    public Item popRight() {
        if (isEmpty()) return null;
        n--;
        Item item = last.item;
        last = last.pre;
        if (isEmpty()) first = last;
        else last.next = null;
        return item;
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
        Deque<Integer> dq = new Deque<Integer>();
        for (int i = 1; i <= 2; i++ ) {
            dq.pushLeft(i);
        }
        for (int i = 3; i <= 4; i++ ) {
            dq.pushRight(i);
        }
        System.out.println(dq);

        dq.popLeft();
        dq.popRight();
        dq.popLeft();
        dq.popRight();
        System.out.println("pop over: " + dq);
        dq.pushRight(1);
        System.out.println(dq);
        dq.pushRight(2);
        System.out.println(dq);
        dq.pushLeft(3);
        System.out.println(dq);        
    }
}
