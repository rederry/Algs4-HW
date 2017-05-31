import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class QuickUnionPathCompressionUF {
    private int[] id;   // index
    private int count;  // component count

    /**
     * Constructor
     */
    public QuickUnionPathCompressionUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Found the root of p
     * Compress the path by link every leaf to the root
     */
    public int find(int p) {
        int root = p;
        while (id[root] != root) 
            root = id[root];
        while (id[p] != root) {
            int oldp = p;
            p = id[p];
            id[oldp] = root;
        } 
        return root;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < id.length; i++)
            s += i + " ";
        s += "\n";
        for (int i = 0; i < id.length; i++)
            s += id[i] + " ";
        return s;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionPathCompressionUF uf = new QuickUnionPathCompressionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + "components");
        //uf.find(3);
        StdOut.println(uf);
    }
}
