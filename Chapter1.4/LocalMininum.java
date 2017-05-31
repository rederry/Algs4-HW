import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class LocalMininum {
    public static int arrayLocalMininumRec(int[] a, int low, int hi) {
        if (low >= hi) return low;
        int mid = low + (hi - low) / 2;
        if (mid == 0) {
            if(a[mid] < a[mid+1]) return mid;
            else return mid+1;
        }
        if (a[mid-1] > a[mid] && a[mid+1] > a[mid])
            return mid;
        else if (a[mid-1] < a[mid+1])
            return arrayLocalMininumRec(a, low, mid-1);
        else
            return arrayLocalMininumRec(a, mid+1, hi);
    }

    public static int arrayLocalMininum(int[] a) {
        int low = 0;
        int hi = a.length - 1;
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            if (mid == 0) {
                if (a[mid] < a[mid+1]) return mid; 
                else return mid+1;
            }
            int left = a[mid-1];
            int right = a[mid+1];
            if (a[mid] < left && a[mid] < right) return mid;
            else if (left < right) hi = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    
    /**
     * @param cor:if find in row array then cor = 1. else find in col array cor = -1.
     *
     */
    public static int matrixLocalMininumRec(int[][] a, int lowi, int hii, int lowj, int hij, int cor) {
        int midi = lowi + (hii-lowi)/2;
        if (cor == 1) {
            int midj = arrayLocalMininum(a[midi]);
        } else {
            int[] colArr =  
        }
         
        return -1;
    }

    public static void testArray() {
        int N = StdIn.readInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdIn.readInt();
        }
        int mini = arrayLocalMininum(a);
        // int mini = arrayLocalMininumRec(a, 0, a.length-1);
        System.out.println(mini);
    }

    public static void main(String[] args)  {
        //testArray();
        int[][] x = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                x[i][j] = StdRandom.uniform(-100, 100);
                System.out.printf("%3d ", x[i][j]);
            }
        System.out.println();
        }
        int[] a = x[][0];
        System.out.println(a[4]);
    }
}
