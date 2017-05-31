import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class WeightedQuickUnionUF {
    private int[] id;   // index
    private int[] size; // weight
    private int count;  // component count

    public WeightedQuickUnionUF(int n) {
        count = n;
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (id[p] != p) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (size[pRoot] > size[qRoot]) {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
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
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + "components");
        StdOut.println(uf);
    }
}
