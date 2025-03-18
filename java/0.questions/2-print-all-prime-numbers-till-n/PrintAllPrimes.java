import java.util.Scanner;

class PrintAllPrimes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt(); // Input lower bound
        int high = scn.nextInt(); // Input upper bound

        // Loop through all numbers in the range [low, high]
        for (int n = low; n <= high; n++) {
            int count = 0; // Counter to track divisors

            // Check divisibility from 2 to sqrt(n)
            for (int div = 2; div * div <= n; div++) {
                if (n % div == 0) { // If n is divisible by div
                    count++;
                    break; // Exit the loop as n is not prime
                }
            }

            // If no divisors found and n > 1, it's prime
            if (count == 0 && n > 1) {
                System.out.println(n + " is prime");
            } else {
                System.out.println(n + " is not prime");
            }
        }
    }
}