import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class WeightedQuickUnionByHeightUF {
    private int[] id;   // index
    private int[] height; // height
    private int count;  // component count

    public WeightedQuickUnionByHeightUF(int n) {
        count = n;
        id = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            height[i] = 1;
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
        if (height[pRoot] > height[qRoot]) {
            id[qRoot] = pRoot;
        } else if (height[pRoot] < height[qRoot]){
            id[pRoot] = qRoot;
        } else {                // the same height 
            id[qRoot] = pRoot;
            height[pRoot]++;
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
        WeightedQuickUnionByHeightUF uf = new WeightedQuickUnionByHeightUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        StdOut.println(uf);
    }
}
