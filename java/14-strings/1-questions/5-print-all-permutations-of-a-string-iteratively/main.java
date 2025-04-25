import java.util.Scanner;

public class main {

    public static int factorial(int n) {
        int val = 1;
        for (int i = 2; i <= n; i++) {
            val *= i;
        }
        return val;
    }

    public static void solution(String str) {
        int n = str.length();
        int f = factorial(n); // Total number of permutations

        for (int i = 0; i < f; i++) {
            StringBuilder sb = new StringBuilder(str);
            int temp = i;

            for (int div = n; div >= 1; div--) {
                int q = temp / div;
                int r = temp % div;

                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);

                temp = q;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter a string:");
        String input = sc.nextLine();

        // Generate all permutations
        System.out.println("All permutations:");
        solution(input);

        sc.close();
    }
}
