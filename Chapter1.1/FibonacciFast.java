
public class FibonacciFast {
    
    static long[] memo = new long[1000];
    
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        long f1 = memo[N-1];
        long f2 = memo[N-2];
        if (f1 == 0) {
            f1 = F(N-1);
            memo[N-1] = f1;
        }
//        if (f1 == 0 || f2 == 0) {
//            f1 = F(N-1);
//            f2 = F(N-2);
//            memo[N-1] = f1;
//            memo[N-2] = f2;
//        }
        return f1 + f2;
    }
    
    public static void main(String[] args) {
        for (int N = 0; N < 100; N++)
            System.out.println(N + " " + F(N));
    }
}