import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // size of array
        int k = scn.nextInt(); // element to find
        int[] arr = new int[n];

        // taking array input
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int low = 0, high = n - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                System.out.println(mid);
                found = true;
                break; // exit the loop when element is found
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("-1"); // if element not found
        }
    }
}
