
public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n = 0;

    public MinPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public isEmpty() {
        return n == 0;
    }

    public isMinHeap() {
        if (isEmpty()) return true;
        for (int i = 1; i < n/2; i++) {
            int left = 2*i;
            int right = 2*i+1;
            if (left <= n && pq[i] > pq[left]) return false;
            if (right <= n && pq[i] > pq[right]) return false;
        }
        return true;
    }

    private boolean less(int i, int j) {
    }

    private void exch(int i, int j) {
    }

    private void swim(int k) {
    }

    private void sink(int k) {
    }

}
