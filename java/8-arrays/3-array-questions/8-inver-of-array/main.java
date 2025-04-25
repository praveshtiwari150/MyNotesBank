import java.util.Scanner;

public class main {

    public static int[] inverse(int[] arr) {
        int[] inv = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            inv[v] = i;
        }

        return inv;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] inv = inverse(arr);

        for (int ele : inv) {
            System.out.print(ele + " ");
        }
    }
}
