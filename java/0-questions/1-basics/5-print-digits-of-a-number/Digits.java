import java.util.Scanner;

class Digits {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // Input number

        // Edge case: Handle n = 0
        if (n == 0) {
            System.out.println(0);
            return;
        }

        // Calculate the number of digits
        int digits = 0;
        int temp = n;
        while (temp != 0) {
            temp = temp / 10;
            digits++;
        }

        // Calculate the divisor (10^(digits - 1))
        int div = (int) Math.pow(10, digits - 1);

        // Print digits from left to right
        while (div != 0) {
            int q = n / div; // Extract the leftmost digit
            System.out.println(q); // Print the digit
            n = n % div; // Remove the leftmost digit
            div = div / 10; // Reduce the divisor
        }
    }
}