import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E1317 {
    public static Transaction[] readTransactions() {
        Queue<Transaction> q = new Queue<Transaction>();
        while (StdIn.hasNextLine()) {
            Transaction d = new Transaction(StdIn.readLine());
            q.enqueue(d);
        }

        int n = q.size();
        Transaction[] a = new Transaction[n];
        for (int i = 0; i < n; i++)
            a[i] = q.dequeue();
        return a;
    }

    public static void main(String[] args) {
        Transaction[] a = readTransactions();
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }
}
