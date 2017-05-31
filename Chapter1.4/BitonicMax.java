import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class BitonicMax {
    public static int[] bitonic(int N) {
        int mid = StdRandom.uniform(N);
        int[] a = new int[N];
        for (int i = 1; i < mid; i++) {
            a[i] = a[i-1] + 1 + StdRandom.uniform(9);
        }

        if (mid > 0) a[mid] = a[mid-1] + StdRandom.uniform(10) - 5;

        for (int i = mid + 1; i < N; i++) {
            a[i] = a[i-1] - 1 - StdRandom.uniform(9);
        }

        for (int i = 0; i < N; i++) {
            StdOut.println(a[i]);
        }
        return a;
    } 

    public static int maxRank(int[] a) {
        if (a.length == 0) return -1;
        if (a.length == 1) return 0;
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (mid == 0)                return a[hi] > a[lo] ? hi : lo;
            else if (a[mid] < a[mid-1])  hi = mid-1;
            else if (a[mid] < a[mid+1])  lo = mid+1;
            else                         return mid;
        }
        return -1;
    }
    
    public static int max(int[] a, int lo, int hi) {
        if (lo >= hi) return hi;
        int mid = lo + (hi-lo)/2;
        if (mid == 0) return a[hi] > a[lo] ? hi : lo;
        else if (a[mid] < a[mid-1]) return max(a, lo, mid-1);
        else if (a[mid] < a[mid+1]) return max(a, mid+1, hi);
        else return mid;
    }

    public static int bsearch(int[] a, int key, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi-lo)/2;
        if (a[mid] > key) return bsearch(a, key, lo, mid-1);
        else if (a[mid] < key) return bsearch(a, key, mid+1, hi);
        else return mid;
    }

    public static int bsearch_r(int[] a, int key, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi-lo)/2;
        if (a[mid] < key) return bsearch_r(a, key, lo, mid-1);
        else if (a[mid] > key) return bsearch_r(a, key, mid+1, hi);
        else return mid;
    }

    public static boolean bitonicSearch(int[] a, int key) {
        int maxIndex = max(a, 0, a.length - 1);
        int r1 = bsearch(a, key, 0, maxIndex);
        if (r1 != -1) return true;
        int r2 = bsearch_r(a, key, maxIndex, a.length-1);
        return r2 != -1;
    }

    public static void main(String[] args) {
        int[] a = bitonic(20);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            StdOut.println(bitonicSearch(a, key));
        }
    }
}
