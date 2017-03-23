import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1315 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            q.enqueue(s);
        }
        int r = q.size() - k;
        for (int i = 0; i < r; i++) q.dequeue();
        StdOut.println("Result:" + q.dequeue());
    }
}
