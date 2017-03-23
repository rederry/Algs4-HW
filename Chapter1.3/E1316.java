import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1316 {
    public static Date[] readDates() {
        Queue<Date> q = new Queue<Date>();
        while (!StdIn.isEmpty())
            q.enqueue(new Date(StdIn.readString()));

        int n = q.size();
        Date[] a = new Date[n];
        for (int i = 0; i < n; i++)
            a[i] = q.dequeue();
        return a;
    }

    public static void main(String[] args) {
        Date[] a = readDates();
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }
}
