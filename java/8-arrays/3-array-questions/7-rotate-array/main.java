import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        rotateAarray(arr, n, k);

        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void reverse(int[] arr, int l, int r){

        while (l<r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            l++;
            r--;
        }
    }
    public static void rotateAarray(int[] arr, int n, int k) {
        // part1
        k = k % n;

        if (k < 0)
            k = k + n;
        reverse(arr, 0, n - k - 1);

        // part2
        reverse(arr, n - k, n - 1);
        
        reverse(arr, 0, n-1);
    }
}
