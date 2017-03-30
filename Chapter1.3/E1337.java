
public class E1337 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < n; i++) q.enqueue(i);
        while (!q.isEmpty()) {
            for (int i = 1; i <= m; i++) {
                int x = q.dequeue();
                if (i != m) q.enqueue(x);
                else System.out.print(x + " ");
            }
        }
        System.out.println();
    }
}
