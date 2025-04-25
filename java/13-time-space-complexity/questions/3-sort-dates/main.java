import java.io.*;
import java.util.*;

public class main {
    public static void countSort(String[] arr, int div, int mod, int range) {
        String[] ans = new String[arr.length];
        int[] farr = new int[range]; // frequency array

        // Step 1: Frequency count
        for (int i = 0; i < arr.length; i++) {
            farr[(Integer.parseInt(arr[i], 10) / div) % mod]++;
        }

        // Step 2: Prefix sum array (cumulative frequency)
        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }

        // Step 3: Stable sort (go backward for stability)
        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (Integer.parseInt(arr[i], 10) / div) % mod;
            int pos = farr[digit] - 1;
            ans[pos] = arr[i];
            farr[digit]--;
        }

        // Step 4: Copy sorted result back to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void sortDates(String[] arr) {
        countSort(arr, 1000000, 100, 32); // days
        countSort(arr, 10000, 100, 13); // months
        countSort(arr, 1, 10000, 2501); // years
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine(); // consume newline
        String[] dates = new String[n];

        for (int i = 0; i < n; i++) {
            dates[i] = scn.nextLine(); // date in format ddmmyyyy (e.g. "12051998")
        }

        sortDates(dates);

        for (String date : dates) {
            System.out.println(date);
        }
    }
}
