/**
 * Exercises 1.3.11
 * EvaluatePostfix
 * Takes from standard input an expression with postfix then evaluate it
 * 
 * e.g.
 * Input:  ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 * Input: 1 2 + 3 4 - 5 6 - * *
 * Output: 3.0
 * 
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {
    public static void main(String[] args) {
        Stack<Double> vals = new Stack<Double>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")) {
                double v = vals.pop();
                v = vals.pop() + v;
                vals.push(v);
            } else if (s.equals("-")) {
                double v = vals.pop();
                v = vals.pop() - v;
                vals.push(v);
            } else if (s.equals("*")) {
                double v = vals.pop();
                v = vals.pop() * v;
                vals.push(v);
            } else if (s.equals("/")) {
                double v = vals.pop();
                v = vals.pop() / v;
                vals.push(v);
            } 
            else vals.push(Double.parseDouble(s)); 
        }
        StdOut.println(vals.pop());
    }
}