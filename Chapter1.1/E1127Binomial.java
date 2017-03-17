public class E1127Binomial {
    
    static double[][] memo = new double[101][101];
    
    public static double binomial(int N, int k, double p) {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        double f1 = memo[N][k+1];
        double f2 = memo[N][k];
        if (f1 == -1 || f2 == -1) {
            f1 = binomial(N-1, k, p);
            f2 = binomial(N-1, k-1, p);
            memo[N][k+1] = f1;
            memo[N][k] = f2;
        }
        return (1.0-p) * f1 + p * f2;
    }
    
    public static double binomial_origin(int N, int k, double p) {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0-p)*binomial_origin(N-1, k, p) + p*binomial_origin(N-1, k-1, p);
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 101; i++)
            for (int j = 0; j < 101; j++)
            memo[i][j] = -1;
        
        System.out.println(binomial(20, 10, 0.25));
        System.out.println(binomial_origin(20, 10, 0.25));

    }
}