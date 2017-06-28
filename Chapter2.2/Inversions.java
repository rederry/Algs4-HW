import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

// E2.2.19
public class Inversions {

    public static int inversions = 0;

    public static void inversion(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        inversion(a, aux, 0, a.length - 1);
    }

    private static void inversion(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo)/2;
        inversion(a, aux, lo, mid);
        inversion(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) 
            aux[i] = a[i];
        int i = lo;
        int j = mid + 1;
        int k = lo;
        while (k <= hi) {
            if (i > mid)                   a[k++] = aux[j++];
            else if (j > hi)               a[k++] = aux[i++];
            else if (less(aux[j], aux[i])) {
                inversions += mid - i + 1;
                a[k++] = aux[j++];
            }
            else                           a[k++] = aux[i++];
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

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Inversions.inversion(a);
        StdOut.println(Inversions.inversions);
    }
}
