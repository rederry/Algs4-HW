import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;

public class BinarySearch {
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
    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        for (int i = 0; i < depth; i++) {
            StdOut.print("  ");
        }
        StdOut.println("depth:" + depth + " lo:" + lo + " hi:" + hi);
        
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1, depth + 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, depth + 1);
        else return mid;
    }
    
    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
//        int count = 100;
//        int[] whitelist = new int[count];
//        for (int i = 0; i < count; i++) {
//            whitelist[i] = StdRandom.uniform(count);
//        }
        StdOut.println();
        Arrays.sort(whitelist);
        int count = 0;
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
//            if (rank(key, whitelist, 0, whitelist.length-1, 1) == -1)
//                StdOut.println(key + " not found");
            if (rank(key, whitelist) == -1)
                count++;
        }
        StdOut.println(count);
    }
}
