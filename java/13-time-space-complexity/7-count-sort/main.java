import java.util.Scanner;

public class main {

    public static void countSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] farr = new int[range]; // frequency array

        // Step 1: Frequency count
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            farr[idx]++;
        }

        // Step 2: Prefix sum array (cumulative frequency)
        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i - 1];
        }

        // Step 3: Stable sort (go backward for stability)
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = farr[val - min];
            int idx = pos - 1;
            ans[idx] = val;
            farr[val - min]--;
        }

        // Step 4: Copy sorted result back to original array
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scn.nextInt();
        int[] arr = new int[n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }

        countSort(arr, min, max);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
