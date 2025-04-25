import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        st.push(n - 1);
        nge[n - 1] = n;

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = n;
            }

            else {
                nge[i] = st.peek();
            }

            st.push(i);
        }
        
        for (int i = 0; i <= arr.length - k; i++) {
            // enter the loop to find maximum of window starting at i
            int j = i;
            while (nge[j] < i + k) {
                j = nge[j];
            }

            ans.add(arr[j]);
        }

        for (int ele : ans) {
            System.out.print(ele + "\t");
        }

        scn.close();

    }
}
