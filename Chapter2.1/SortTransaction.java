import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.List;

public class SortTransaction {

    public static Transaction[] readTransactions() {
        List<Transaction> list = new ArrayList<Transaction>();
        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            Transaction trans = new Transaction(line);
            list.add(trans);
        }

        int n = list.size();
        Transaction[] ts = new Transaction[n];
        for (int i = 0; i < n; i++)
            ts[i] = list.get(i);
        return ts;
    }

    public static void main(String[] args) {
        Transaction[] transactions = readTransactions();
        Shell.sort(transactions);
        for (int i = 0; i < transactions.length; i++)
            StdOut.println(transactions[i]);
    }
}
