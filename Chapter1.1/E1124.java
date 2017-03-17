public class E1124 {
    public static int Euclid(int p, int q) {
        System.out.printf("p:%4d  q:%4d\n", p, q);
        if (q == 0) return p;
        int r = p % q;
        return Euclid(q, r);
    }
    
    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        System.out.println(Euclid(105, 24));
    }
}
    