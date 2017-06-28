import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
 * Quicksort with sentinel
 * 2.3.17
 */
public class QuickSentinel {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        int max = 0;
        for (int i = 0; i < a.length; i++)
            if (less(a[max], a[i])) max = i;
        exch(a, max, a.length-1);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], pivot));
            while (less(pivot, a[--j])); 
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) 
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        StdOut.println(isSorted(a));
    }
}
