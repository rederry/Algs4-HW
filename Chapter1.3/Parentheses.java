/*************************************
  * Exercises 1.3.4
*************************************/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    
//    private static final String 
    
    public static boolean isBalanced(String s) {
        Stack<Character> a = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' ) {
                a.push(c);
            } else if (c == ')') {
                if (a.isEmpty()) return false;
                if (a.pop() != '(') return false;
            } else if (c == '[') {
                a.push(c);
            } else if (c == ']') {
                if (a.isEmpty()) return false;
                if (a.pop() != '[') return false;
            } else if (c == '{') {
                a.push(c);
            } else if (c == '}') {
                if (a.isEmpty()) return false;
                if (a.pop() != '{') return false;
            } else {
                return false;
            }
        }
        return a.isEmpty();
    }
    
    public static void main(String[] args) {
        String s = StdIn.readString();
        StdOut.println(isBalanced(s));
    }
}