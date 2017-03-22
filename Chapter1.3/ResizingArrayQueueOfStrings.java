
public class ResizingArrayQueueOfStrings {
    private String[] a =  new String[1];
    private int N = 0;
    private int head = 0;
    private int tail = 0;
    
    public boolean isEmpty() { 
        return N == 0;
    }
    
    public int size() {
        return N;
    }
    
    /**
     * Creat a new array with max size
     * insert the new array to the a's tail
     */
    private void resize(int max) {
        String[] tmp = new String[max];
        for (int i = 0, j = head; i < max; i++) {
            if (i <= tail) tmp[i] = a[i];
            else if (i > tail + max / 2) {
                tmp[i] = a[j++];
            }
        }
        if (head > tail)
            head = head + max / 2;
        a = tmp;
    }
    
    public void enqueue(String s) {
         if ((tail + 1) % a.length == head) resize(2 * a.length);
         a[tail] = s;
         tail = (tail + 1) % a.length;
         N++;
         
         for (int i = 0; i < a.length; i++) {
             System.out.print(a[i] + " ");   
         }
         System.out.println(" head:" + head + " tail:" + tail);
    }
    
    public String dequeue() {
        String s = a[head];
        a[head] = null;
        head = (head + 1) % a.length;
        
        for (int i = 0; i < a.length; i++) {
             System.out.print(a[i] + " ");   
         }
         System.out.println(" head:" + head + " tail:" + tail);
         
        return s;
    }
    
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();
        for (int i = 0; i < 5; i++) {
            q.enqueue("i" + i);
        }
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        q.enqueue("i" + 5);
        q.enqueue("i" + 6);
        q.enqueue("i" + 7);
        q.enqueue("i" + 8);
        q.enqueue("i" + 9);
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        q.enqueue("i" + 10);
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        System.out.println("dequeue:" + q.dequeue());
        q.enqueue("i" + 11);
    }
}