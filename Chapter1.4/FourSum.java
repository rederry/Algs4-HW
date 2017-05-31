import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class FourSum {
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == 0)
                            count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
       int[] a = In.readInts(args[0]);
       StdOut.println(a.length);
       StdOut.println(count(a));
    }
}
