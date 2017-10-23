import edu.princeton.cs.algs4.MinPQ;

public class CubeSum implements Comparable<CubeSum> {

    private double sum;
    private double a;
    private double b;

    public CubeSum(double a, double b) {
        this.a = a;
        this.b = b;
        sum = a*a*a + b*b*b;
    }

    @Override
    public int compareTo(CubeSum o) {
        if (this.sum < o.sum) return -1;
        if (this.sum > o.sum) return 1;
        return 0;
    }

    public String toString() {
        return sum + " = " + a + "^3 + " + b + "^3";
    }

    public static void main(String[] args) {
        double n = Integer.parseInt(args[0]);
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i < n; i++) {
            CubeSum cs = new CubeSum(i, i);
            pq.insert(cs);
        }

        CubeSum pre = new CubeSum(-1, -1);
        while (!pq.isEmpty()) {
            CubeSum cs = pq.delMin();
            if (cs.sum == pre.sum)
                System.out.println(cs + " and " + pre);
            if (cs.b < n) pq.insert(new CubeSum(cs.a, cs.b+1));
            pre = cs;
        }
    }

}
