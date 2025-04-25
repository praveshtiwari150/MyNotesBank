import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        scn.close();

        int ans = convertAnyBaseToDecimal(n, b);
        System.out.println(ans);
    }

    public static int convertAnyBaseToDecimal(int n, int b) {
        int rv = 0;

        int p = 1;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;

            rv += digit * p;
            p = p * b;
        }

        return rv;
    }
}
