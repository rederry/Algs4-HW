import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.MaxPQ;
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;

/**
 * A dynamic median priority queue
 * insert in logarithmic time, find the median in constant time, and remove the median in logarithmic time.
 */

public class MedianPQ<Key extends Comparable<Key>> {
    
    private int n;
    private MinPQ<Key> minPQ;
    private MaxPQ<Key> maxPQ;

    public MedianPQ() {
        maxPQ = new MaxPQ<Key>();
        minPQ = new MinPQ<Key>();
        n = 0;
    }

    public void insert(Key x) {
        if (size() == 0 || x.compareTo(median()) == 1) minPQ.insert(x);
        else maxPQ.insert(x);
        rearrange();
        n++;
    }
    
    public Key delMedian() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key k = maxPQ.delMax();
        n--;
        rearrange();
        return k;
    }

    public Key median() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return maxPQ.max();
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    /**
     * Invariant: maxPQ.size() - minPQ.size() = 1 and maxPQ.size() > minPQ.size()
     *            or maxPQ.size() = minPQ.size()
     */
    private void rearrange() {
        if (maxPQ.size() < minPQ.size()) maxPQ.insert(minPQ.delMin());
        if (maxPQ.size() - minPQ.size() > 1) minPQ.insert(maxPQ.delMax());
    }


    /**
     * Unit tests the DynamicMedianPQ
     * Output: 5 6 4 7 3
     *         7 8 6 8 5 9 2 9 1 10
     */
    public static void main(String[] args) {
        MedianPQ<Integer> pq = new MedianPQ<Integer>();
        for (int i = 1; i < 11; i++)
            pq.insert(i);
        for (int i = 0; i < 5; i++)
            System.out.print(pq.delMedian() + " ");
        System.out.println();
        for (int i = 5; i < 10; i++)
            pq.insert(i);
        while (!pq.isEmpty())
            System.out.print(pq.delMedian() + " ");
        System.out.println();
    }
}
