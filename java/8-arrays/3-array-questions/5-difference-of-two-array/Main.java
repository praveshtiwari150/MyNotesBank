import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }

        int[] diff = new int[n2]; // Since n2 > n1, diff array should have size n2
        int c = 0; // Carry (borrow)

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = diff.length - 1;

        while (k >= 0) {
            int a1v = i >= 0 ? arr1[i] : 0;
            int d;

            if (arr2[j] + c >= a1v) {
                d = arr2[j] + c - a1v;
                c = 0;
            } else {
                d = arr2[j] + c + 10 - a1v;
                c = -1; // Borrow from the next digit
            }

            diff[k] = d;

            i--;
            j--;
            k--;
        }

        // Skip leading zeros, but ensure at least one digit is printed
        int index = 0;
        while (index < diff.length - 1 && diff[index] == 0) {
            index++;
        }

        while (index < diff.length) {
            System.out.print(diff[index] + "\t");
            index++;
        }

        scn.close();
    }
}
