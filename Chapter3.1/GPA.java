import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

public class GPA {
    public static void main(String[] args) {
        ST<String, Double> st = new ST<String, Double>();
        st.put("A+", 4.33);
        st.put("A", 4.00);
        st.put("A-", 3.67);
        st.put("B+", 3.33);
        st.put("B", 3.00);
        st.put("B-", 2.67);
        st.put("C+", 2.33);
        st.put("C", 2.00);
        st.put("C-", 1.67);
        st.put("D", 1.00);
        st.put("F", 0.00);

        Double sum = 0.00;
        int n = 0;
        while (!StdIn.isEmpty()) {
            String grade = StdIn.readString();
            if (st.contains(grade)) {
                sum += st.get(grade);
                n++;
            }
        }
        if (n != 0) System.out.println("The GPA is: " + sum/n);
        else        System.out.println("The GPA is: 0");
    }
}
