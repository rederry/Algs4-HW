import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

// E2.2.9
public class Merge {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        mergeX(a, aux, lo, mid, hi);
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
            else if (less(aux[j], aux[i])) a[k++] = aux[j++];
            else                           a[k++] = aux[i++];
        }
    }

    private static void mergeX(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= mid; i++)
            aux[i] = a[i];
        for (int i = hi, j = mid+1; i >= mid+1; i--) {
            aux[j] = a[i];
            j++;
        }

        int i = lo;
        int j = hi;
        for (int k = lo; k <= hi; k++) {
            if (less(aux[j], aux[i])) a[k] = aux[j--];
            else                      a[k] = aux[i++];
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
        Merge.sort(a);
        show(a);
    }
}
