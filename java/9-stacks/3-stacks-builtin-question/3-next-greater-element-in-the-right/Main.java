import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        int[] nge = new int[arr.length];

        // First, take input for the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        Stack<Integer> st = new Stack<>();

        // Process last element separately
        st.push(arr[arr.length - 1]);
        nge[arr.length - 1] = -1; // Last element always has -1 as NGE

        // Loop for the remaining elements
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= st.peek()) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

        st.push(arr[i]);
        }

        // Print the NGE array correctly
        for (int i = 0; i < nge.length; i++) {
            System.out.print(nge[i] + " ");
        }

        scn.close();
    }
}
