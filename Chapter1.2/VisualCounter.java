import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class VisualCounter {
    private int count;
    private final int N;
    private final int max;
    private int op;
    
    public VisualCounter(int N, int max) {
        this.N = N;
        this.max = max;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-max, max);
        StdDraw.setPenRadius(.0005);
    }
    
    public void increment() {
        if (Math.abs(count) < max && op < N) {
            count++;
            op++;
            StdDraw.point(op, count);
        }
    }
    
    public void decrement() {
        if (Math.abs(count) < max && op < N) {
            count--;
            op++;
            StdDraw.point(op, count);
        }
    }
    
    public int tally() {
        return count;
    }
    
    public static void main(String[] args) {
        VisualCounter vc = new VisualCounter(500, 500);
        for (int i = 0; i < 400; i++) {
            if (StdRandom.uniform() < 0.65)
                vc.increment();
            else
                vc.decrement();
        }
    }
}