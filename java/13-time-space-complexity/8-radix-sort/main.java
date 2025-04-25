import java.util.*;

public class main {

    public static void countSort(int[] arr, int exp) {
        int[] farr = new int[10]; // frequency array

        // Step 1: Frequency count
        for (int i = 0; i < arr.length; i++) {
            farr[(arr[i] / exp) % 10]++;
        }

        // Step 2: Prefix sum array (cumulative frequency)
        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }

        // Step 3: Stable sort (go backward for stability)
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            int pos = farr[digit] - 1;
            ans[pos] = arr[i];
            farr[digit]--;
        }

        // Step 4: Copy sorted result back to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val > max)
                max = val;
        }

        int exp = 1;
        while (exp <= max) {
            countSort(arr, exp);
            exp *= 10;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scn.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        radixSort(arr);

        System.out.println("Sorted array:");
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
