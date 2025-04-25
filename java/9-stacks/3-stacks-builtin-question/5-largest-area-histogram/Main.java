import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] rb = new int[n]; // nse index on the right
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        rb[n - 1] = n;

        for(int i = n-2; i>=0; i--){
            while (st.size() > 0 && arr[i] < arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                rb[i] = arr.length;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }

        int[] lb = new int[n]; // nse index on the left
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;

        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }

        System.out.print(maxArea);
    }
}
