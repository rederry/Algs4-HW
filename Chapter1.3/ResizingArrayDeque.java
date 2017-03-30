
public class ResizingArrayDeque<Item> {
    private Item[] q;       // queue elements
    private int n;          // number of elements on queue
    private int first;      // index of first element of queue
    private int last;       // index of next available slot


    /**
     * Initializes an empty queue.
     */
    public ResizingArrayDeque() {
        q = (Item[]) new Object[2];
        n = 0;
        first = 0;
        last = 0;
    }
    
    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void resize(int capacity) {
        Item[] tmp = (Item[]) new Object[capacity];
        int offset = q.length / 2;
        for (int i = first; i <= last; i++) {
            tmp[i + offset] = q[i];
        }
        q = tmp;
        first += offset;
        last += offset;
    }

    public void pushLeft(Item item) {
        if (isEmpty()) { q[first] = item; n++; return; }
        if (first == 0) resize(2*q.length);
        q[--first] = item;
        n++;
    }

    public void pushRight(Item item) {
        if (isEmpty()) { q[last] = item; n++; return;}
        if (last == q.length) resize(2*q.length);
        q[++last] = item;
        n++;
    }

    public Item popLeft() {
        if (isEmpty()) return null;
        Item item = q[first];
        q[first++] = null;
        n--;
        return item;
    }

    public Item popRight() {
        if (isEmpty()) return null;
        Item item = q[last];
        q[last--] = null;
        n--;
        return item;
    }

    @Override
    public String toString() {
        //System.out.println(first + " " + last);
        String s = "";
        for (int i = 0; i <q.length; i++) {
            s = s + q[i] + "8 ";
        }
        return s;
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> dq = new ResizingArrayDeque<Integer>();
        for (int i = 1; i <= 5; i++ ) {
            dq.pushLeft(i);
        }
        for (int i = 6; i <= 10; i++ ) {
            dq.pushRight(i);
        }
        System.out.println(dq);

        for (int i = 0; i < 10; i++) {
            dq.popLeft();
        }
        dq.pushLeft(11);
        dq.pushLeft(11);
        dq.pushLeft(11);
        System.out.println(dq);
        // dq.pushRight(10);
        // System.out.println(dq);
        // dq.pushRight(11);
        // System.out.println(dq);
        // dq.pushLeft(12);
        // System.out.println(dq);        
    }    
}
