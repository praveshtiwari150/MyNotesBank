import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Stack<Integer> vs = new Stack<>(); // For evaluating the expression
        Stack<String> is = new Stack<>(); // For infix expression
        Stack<String> ps = new Stack<>(); // For prefix expression

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // Pop values for evaluation
                int v2 = vs.pop();
                int v1 = vs.pop();
                int val = operation(v1, v2, ch);
                vs.push(val);

                // Pop values for infix
                String iv2 = is.pop();
                String iv1 = is.pop();
                String ival = "(" + iv1 + ch + iv2 + ")"; // Corrected
                is.push(ival);

                // Pop values for prefix
                String pv2 = ps.pop();
                String pv1 = ps.pop();
                String pval = ch + pv1 + pv2; // Corrected
                ps.push(pval);
            } else {
                // Push operand values as integers
                vs.push(ch - '0');
                // Convert operand to string for infix and prefix
                is.push(ch + "");
                ps.push(ch + "");
            }
        }

        System.out.println("Value: " + vs.pop());
        System.out.println("Infix: " + is.pop());
        System.out.println("Prefix: " + ps.pop());
    }

    public static int operation(int v1, int v2, char op) {
        if (op == '+') {
            return v1 + v2;
        } else if (op == '-') {
            return v1 - v2;
        } else if (op == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}
