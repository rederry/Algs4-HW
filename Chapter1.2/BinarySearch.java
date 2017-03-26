import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;

public class BinarySearch {
    public static int rank(int key, int[] a, Counter c) {
        int lo = 0;
        int hi = a.length-1;
        while (hi >= lo) {
            c.increment();
            int mid = lo + (hi - lo) / 2;
            if (key == a[mid]) return mid;
            if (key < a[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int count = 100;
        int[] whitelist = new int[count];
        for (int i = 0; i < count; i++) {
            whitelist[i] = StdRandom.uniform(count);
        }
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            Counter c = new Counter("bs");
            int r = rank(key, whitelist, c);
            StdOut.println(c.tally());
        }
    }
}
