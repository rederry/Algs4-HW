

public class ErdosRenyi {


    public static main(String[] args) {
        int n = Integer.parseInt(args[0]);
        WeightedQuickUnionPathCompressionUF uf = new WeightedQuickUnionPathCompressionUF(n);

        while (true) {
            int p = StdRandom.uniform(0, n-1);
            int q = StdRandom.uniform(0, n-1);
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }

    }
}
