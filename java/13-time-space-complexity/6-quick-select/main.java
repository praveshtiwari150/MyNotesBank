import java.util.Scanner;

public class main {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Partition using Lomuto's scheme
    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, hi);
        return i + 1;
    }

    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        if (lo <= hi) {
            int pi = partition(arr, lo, hi);

            if (pi == k) {
                return arr[pi];
            } else if (pi < k) {
                return quickSelect(arr, pi + 1, hi, k);
            } else {
                return quickSelect(arr, lo, pi - 1, k);
            }
        }
        return -1; // Edge case: invalid k
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt(); // k = kth smallest element (1-based index)

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // Since arrays are 0-indexed, use k - 1
        int ans = quickSelect(arr, 0, n - 1, k - 1);
        System.out.println(ans);
    }
}
