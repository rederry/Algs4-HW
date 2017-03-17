import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;

public class E1128 {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length-1;
        while (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            if (key == a[mid]) return mid;
            if (key < a[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }
    
    public static void main(String[] args) {
//        int[] whitelist = In.readInts(args[0]);
        int count = 100;
        int[] whitelist = new int[count];
        for (int i = 0; i < count; i++) {
            whitelist[i] = StdRandom.uniform(count);
        }
        StdOut.println();
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist, 0, whitelist.length-1) == -1)
                StdOut.println(key + " not found");
        }
    }
}
