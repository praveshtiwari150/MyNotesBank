import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Stack<String> postfix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Opening parenthesis
            if (ch == '(') {
                ops.push(ch);
            }
            // Operand (digits or alphabets)
            else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                prefix.push(ch + "");
                postfix.push(ch + "");
            }
            // Closing parenthesis - solve sub-expression
            else if (ch == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    processStacks(postfix, prefix, ops);
                }
                ops.pop(); // Remove '('
            }
            // Operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!ops.isEmpty() && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {
                    processStacks(postfix, prefix, ops);
                }
                ops.push(ch);
            }
        }

        // Process remaining operators
        while (!ops.isEmpty()) {
            processStacks(postfix, prefix, ops);
        }

        // Final result
        System.out.println("Prefix: " + prefix.pop());
        System.out.println("Postfix: " + postfix.pop());
    }

    // Helper method to pop operators and update postfix & prefix stacks
    public static void processStacks(Stack<String> postfix, Stack<String> prefix, Stack<Character> ops) {
        char op = ops.pop();

        // Postfix evaluation
        String postv2 = postfix.pop();
        String postv1 = postfix.pop();
        String postv = postv1 + postv2 + op;
        postfix.push(postv);

        // Prefix evaluation
        String prev2 = prefix.pop();
        String prev1 = prefix.pop();
        String prev = op + prev1 + prev2;
        prefix.push(prev);
    }

    // Method to return precedence of operators
    public static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}
