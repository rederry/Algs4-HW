import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;

public class E1129 {
    public static int rank(int key, int[] a) {
        int r = aux(key, a, 0, a.length-1);
        while (r != 0 && r < a.length && a[r] == a[r-1]) r--;
        return r;
    }
    
    private static int aux(int key, int[] a, int lo, int hi) {
        if (lo > hi) return lo;
        int mid = lo + (hi - lo) / 2;
        if (key > a[mid]) return aux(key, a, mid + 1, hi);
        else if (key < a[mid]) return aux(key, a, lo, mid - 1);
        else return mid;
    }
    
    public static void main(String[] args) {
        int[] a = {1,2,3,5,5,5,5,5,5,9,20};
        Arrays.sort(a);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            StdOut.println(rank(key, a));
        }
    }
}
