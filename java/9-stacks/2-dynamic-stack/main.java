import java.util.*;

public class main {

    public static class DynamicStack {
        int[] data;
        int tos;

        public DynamicStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            return tos + 1;
        }

        void display() {
            for (int i = tos; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void push(int val) {
            if (tos == data.length - 1) {
                int[] ndata = new int[2 * data.length];
                for (int i = 0; i < data.length; i++) {
                    ndata[i] = data[i];
                }

                // data array point to new data
                data = ndata;
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
        DynamicStack st = new DynamicStack(3);

        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println("Top: " + st.top()); 
        st.display();
        st.pop(); 
        System.out.println("Top after pop: " + st.top()); 
    }
}
