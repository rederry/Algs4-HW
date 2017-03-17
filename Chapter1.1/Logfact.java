public class Logfact {
    public static double lnfact(int N) {
        if (N == 1) return Math.log(1);
        return Math.log(N) + lnfact(N - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(lnfact(30));
        Double d = new Double(33.0);
        System.out.println(d.intValue() / d == 1);
    }
}
    