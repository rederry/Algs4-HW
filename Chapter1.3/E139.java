/**
 * Parentheses Completion
 * Takes from standard input an expression without left parentheses
 * prints the equivalent in?x expression with the parentheses inserted.
 * 
 * e.g.
 * Input:  1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * Output: ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 * 
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E139 {
    
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<String> vals = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                String v = vals.pop();
                v = "(" + " " + vals.pop() + " " + op + " " + v + " " + s;
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