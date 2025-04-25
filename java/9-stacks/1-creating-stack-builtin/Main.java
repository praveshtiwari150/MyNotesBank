import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Stack<Integer> st = new Stack();

        st.push(10);
        st.push(20);
        System.out.println(st);
        st.push(30);
        System.out.println(st);
        st.push(40);
        System.out.println(st);
        System.out.println(st + " -> " +st.peek() + " -> " + st.size());

        st.pop();
        System.out.println(st + " -> " + st.peek() + " -> " + st.size());

        st.pop();
        System.out.println(st + " -> " + st.peek() + " -> " + st.size());

        st.pop();
        System.out.println(st + " -> " + st.peek() + " -> " + st.size());

    }
}
