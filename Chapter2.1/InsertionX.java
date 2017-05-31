import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class InsertionX {

    private static final int height = 5;

    public static void sort(Comparable[] a) {
        int n = a.length;
        int min = 0;
        for (int i = 0; i < n; i++) {
            if (less(a[i], a[min]))
                min = i;
        }
        exch(a, 0, min);
        
        for (int i = 1; i < n; i++) {
            for(int j = i; less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(0.1, 0.8);
        
        sort(a);
        assert isSorted(a);
        StdOut.println("complete");
    }
}
