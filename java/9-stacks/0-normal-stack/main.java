import java.util.*;

public class main {

    public static class CustomStack {
        int[] data;
        int tos;

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            return tos + 1;
        }

        void display() {
            for (int i = tos; i >= 0; i--) {
                System.out.print(data[i] + " "); // Changed println to print for cleaner output
            }
            System.out.println(); // New line after display
        }

        void push(int val) {
            if (tos == data.length - 1) {
                System.out.println("Stack overflow");
            } else {
                tos++;
                data[tos] = val;
            }
        }

        int pop() {
            if (tos == -1) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos];
                tos--;
                return val;
            }
        }

        int top() {
            if (tos == -1) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        CustomStack st = new CustomStack(n);

        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println("Top: " + st.top()); // Prints the top of the stack
        st.display(); // Displays all elements in the stack
        st.pop(); // Pops the top element
        System.out.println("Top after pop: " + st.top()); // Prints the new top of the stack
    }
}
