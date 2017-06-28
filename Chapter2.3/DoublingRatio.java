import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 2.3.18
 */
public class DoublingRatio {
    public static double timeTrial(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(0, n/2);
        Stopwatch timer = new Stopwatch();
        Quick.sort(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(500);
        for (int n = 1000; true; n += n) {
            double sum = 0;
            for (int i = 0; i < 100; i++) 
                sum += timeTrial(n);
            double time = sum/100.0;
            //double time = timeTrial(n);
            StdOut.printf("%8d %7.1f ", n, time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
