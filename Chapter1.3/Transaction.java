
public class Transaction {
    private final String who;
    private final Date date;
    private final double amount;
    
    public Transaction(String who, Date date, double amount) {
        this.who = who;
        this.date = date;
        this.amount = amount;
    }
    
    public Transaction(String trans) {
        String[] fields = trans.split("\\s+");
        if (fields.length != 3) throw new IllegalArgumentException();
        String who = fields[0];
        String date = fields[1];
        double amount = Double.parseDouble(fields[2]);
        this.who = who;
        this.date = new Date(date);
        this.amount = amount;
    }
        
    public String who() {
        return who;
    }
    
    public Date date() {
        return date;
    }
    
    public double amount() {
        return amount;
    }
    
    public String toString() {
        return who + " transact " + amount + " at " + date;
    }
    
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null) return false;
        System.out.println(this.getClass());
        System.out.println(that.getClass());
        if (this.getClass() != that.getClass()) return false;
        Transaction thatTransaction = (Transaction) that;
        if (this.who != thatTransaction.who) return false;
        if (!this.date.equals(thatTransaction.date)) return false;
        if (this.amount != thatTransaction.amount) return false;
        return true;
    }
    
    public static void main(String[] args) {
        Transaction t1 = new Transaction("kang", new Date(3, 18, 2017), 1000);
        Transaction t2 = new Transaction("kang", new Date(3, 18, 2017), 1000);
        Transaction t3 = new Transaction("kang 3/18/2017 1000");
        System.out.println(t3.date());
        System.out.println(t1.equals(t3));
    }
}