import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // Read the size of the array
        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // Initialize min and max with first element
        int min = arr[0];
        int max = arr[0];

        // Traverse to find min and max
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Calculate and print span
        int span = max - min;
        System.out.println(span);

        scn.close();
    }
}
