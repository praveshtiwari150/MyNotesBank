import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        reverseArray(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }    }

    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move the pointers
            left++;
            right--;
        }
    }
}
