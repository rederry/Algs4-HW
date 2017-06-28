import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/** Only contain 2 key */
class Sort2distinct {

    public static void sort(int[] a) {
        int i = 0;
        int j = 0;
        while (i < a.length - 1) {
            if (a[++i] < a[j])
                swap(a, i, j++);
            else if (a[i] > a[j])
                j = i;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[5];
        for (int i = 0; i < 5; i++)
            a[i] = StdIn.readInt();
        sort(a);
        for (int i = 0; i < 5; i++)
            StdOut.print(a[i] + ", ");
    }
}
