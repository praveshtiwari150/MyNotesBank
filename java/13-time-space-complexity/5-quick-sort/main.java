import java.util.Scanner;

public class main {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Lomuto partition scheme
    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi]; // last element as pivot
        int i = lo - 1; // i is the index for smaller element

        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, hi); // place pivot in the correct position
        return i + 1; // return pivot index
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pi = partition(arr, lo, hi);

            quickSort(arr, lo, pi - 1);
            quickSort(arr, pi + 1, hi);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        quickSort(arr, 0, n - 1);

        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
}
