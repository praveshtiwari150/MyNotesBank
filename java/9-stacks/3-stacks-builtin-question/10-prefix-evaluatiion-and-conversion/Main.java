import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close(); // Close scanner after input

        Stack<Integer> vs = new Stack<>();
        Stack<String> is = new Stack<>();
        Stack<String> ps = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v1 = vs.pop();
                int v2 = vs.pop();
                int val = operation(v1, v2, ch);
                vs.push(val);

                String inv1 = is.pop();
                String inv2 = is.pop();
                String inval = "(" + inv1 + ch + inv2 + ")";
                is.push(inval);

                String pov1 = ps.pop();
                String pov2 = ps.pop();
                String pval = pov1 + pov2 + ch;
                ps.push(pval);
            } else {
                vs.push(ch - '0'); // Convert char to int
                is.push(ch + ""); // Convert char to string
                ps.push(ch + "");
            }
        }

        // Print final results
        System.out.println("Value: " + vs.pop());
        System.out.println("Infix: " + is.pop());
        System.out.println("Postfix: " + ps.pop());
    }

    public static int operation(int v1, int v2, char op) {
        switch (op) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            case '/':
                return v1 / v2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}
