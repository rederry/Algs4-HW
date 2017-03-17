public class Moirai {
    
    private static int balance;
    
    private static void deposit() {
        balance = balance + 1;
    }
    private static void withdraw() {
        balance = balance - 1;
    }
                    
    private static void cashMachine() {
        for (int i = 0; i < 10000000; ++i) {
            deposit(); // put a dollar in
            withdraw(); // take it back out
        }
    }
    
    public static void run() {
        Thread clotho = new Thread(new Runnable() {
            public void run() { System.out.println("spinning"); };
        });
        clotho.start();
        new Thread(new Runnable() {
            public void run() { System.out.println("measuring"); };
        }).start();
        new Thread(new Runnable() {
            public void run() { System.out.println("cutting"); };
        });
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            cashMachine();
            System.out.println(balance);
        }
//        for (int i = 0; i < 10; i++) {
//            run();
//            System.out.println("--------------");
//        }
    }
}