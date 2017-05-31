import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Insertion {

    private static final int height = 5;

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int min = i;
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
                min--;
                //show(a);
            }
            draw(a, i, min);
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    /**
     * E2.17
     */
    private static void show(Comparable[] a) {
        StdDraw.clear();
        int n = a.length;
        double width = 1.0 / n;
        double x = 0;
        double y1 = 0;
        double y2;
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < n; i++) {
            x = x + width;
            y2 = (Double) a[i];
            StdDraw.line(x, y1, x, y2);
        }
    }

    /**
     * E2.18
     */
    private static void draw(Comparable[] a, int row, int min) {
        int n = a.length;
        double width = 0.8 / n;
        double x = 0.1;
        double y1 = (n - row) * height;
        double y2 = 0; 
        for (int i = 0; i < n; i++) {
            x = x + width;
            y2 = y1 + ((double)a[i] * height);
            if (i < row && i > min) 
                StdDraw.setPenColor();
            else if (i == min)
                StdDraw.setPenColor(StdDraw.RED);
            else
                StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.line(x, y1, x, y2);
        }
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(0.1, 0.8);

        StdDraw.setCanvasSize(512, 680);
        StdDraw.setYscale(0.0, (double)a.length * (height+1));
        StdDraw.setPenRadius(0.004);

        sort(a);
        assert isSorted(a);
        StdOut.println("complete");
    }
}
