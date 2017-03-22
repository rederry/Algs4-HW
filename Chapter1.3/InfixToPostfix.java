/**
 * Exercises 1.3.10
 * InfixToPostfix
 * Takes from standard input an expression with infix trans to postfix
 * 
 * e.g.
 * Input:  ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 * Output: 1 2 + 3 4 - 5 6 - * *
 * 
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix {
    
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<String> vals = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("(")) ;
            else if (s.equals(")")) {
                String op = ops.pop();
                String v = vals.pop();
                v = vals.pop() + " " + v + " " + op;
                vals.push(v);
            }
            else vals.push(s);     
        }
        while (!vals.isEmpty()) {
            StdOut.print(vals.pop());
        }
        StdOut.println();
    }
}