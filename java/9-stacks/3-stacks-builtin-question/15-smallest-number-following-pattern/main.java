import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Integer> st = new Stack<>();
        int num = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'd') {
                st.push(num);
                num++;
            } else if (ch == 'i') {
                st.push(num);
                num++;

                while (!st.isEmpty()) {
                    System.out.print(st.pop() + " ");
                }
            }
        }

        st.push(num);

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}
