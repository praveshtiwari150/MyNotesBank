import java.util.*;

public class Main {
    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        int[] stock_span = new int[n];
        st.push(0);
        stock_span[0] = 1;

        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                stock_span[i] = i + 1;
            } else {
                stock_span[i] = i - st.peek();
            }

            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(stock_span[i] + "\t");
        }

        scn.close();
    }
}
