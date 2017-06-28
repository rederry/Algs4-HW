

public class QuickBest {

    private static int j = 0;
    
    public static int[] quickBest(int n) {
        int[] a = new int[n];
        quickBestRec(a, 0, n-1, 0);
        return a;
    }

    private static void quickBestRec(int[] a, int lo, int hi, int i) {
        if (hi < lo) return;
        int mid = lo + (hi-lo)/2;
        a[j++] = mid;
        quickBestRec(a, lo, mid-1, i+1);
        quickBestRec(a, mid+1, hi, mid+1);
    }

     // postcondition: a[lo..hi] is best-case input for quicksorting that subarray
    private static void best(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        best(a, lo, mid-1);
        best(a, mid+1, hi);
        exch(a, lo, mid);
    }

    public static int[] best(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = i;
        best(a, 0, n-1);
        return a;
    }

    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        //int[] a = quickBest(n);
        int[] a = best(n);
        for (int i = 0; i < n; i++)
            System.out.println(a[i] + ", ");
    }
}
