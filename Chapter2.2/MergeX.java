import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

// E2.2.11
public class MergeX {

    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(a, aux, 0, a.length - 1, false);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi, boolean step) {
        if ((hi-lo) < 15) {
            insertionSort(a, lo, hi);
            return;
        }

        int mid = lo + (hi - lo)/2;

        if (!less(a[mid], a[mid+1])) return;

        if (step) {
            sort(a, aux, lo, mid, !step);
            sort(a, aux, mid+1, hi, !step);
        } else {
            sort(aux, a, lo, mid, !step);
            sort(aux, a, mid+1, hi, !step);
        }
        merge(a, aux, lo, mid, hi, step);
    }

   private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi, boolean step) {
        if (step) {
            for (int i = lo; i <= hi; i++) 
                aux[i] = a[i];
        }

        int i = lo;
        int j = mid + 1;
        int k = lo;
        while (k <= hi) {
            if (i > mid)                   a[k++] = aux[j++];
            else if (j > hi)               a[k++] = aux[i++];
            else if (less(aux[j], aux[i])) a[k++] = aux[j++];
            else                           a[k++] = aux[i++];
        }
    }

    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j] , a[j-1]); j--) {
                Comparable tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
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

    // public static void main(String[] args) {
    //     String[] a = StdIn.readAllStrings();
    //     Merge.sort(a);
    //     show(a);
    // }
}
