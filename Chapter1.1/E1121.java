import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
    
public class E1121 {
    public static void main(String[] args) {
        ArrayList<String> excel = new ArrayList<String>();
        while (StdIn.hasNextLine())
            excel.add(StdIn.readLine());
        
        for (String line : excel) {
            String[] row = line.split(" ");
            StdOut.printf("%s ", row[0]);
            StdOut.printf("%s ", row[1]);
            StdOut.printf("%s ", row[2]);
            StdOut.printf("%.3f \n", Float.parseFloat(row[1]) / Float.parseFloat(row[2]));
        }
    }
}