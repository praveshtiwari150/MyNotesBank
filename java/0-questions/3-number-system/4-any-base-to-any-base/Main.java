import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();
        scn.close();

        int decimal = anyBaseToDecimal(n, b1);
        int converted = decimalToAnyBase(decimal, b2);

        System.out.print(converted);
    }

    // Step 1: Convert from base b1 to decimal
    public static int anyBaseToDecimal(int n, int base) {
        int result = 0;
        int power = 1;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            result += digit * power;
            power *= base;
        }
        return result;
    }

    // Step 2: Convert from decimal to base b2
    public static int decimalToAnyBase(int n, int base) {
        int result = 0;
        int power = 1;
        while (n > 0) {
            int digit = n % base;
            n /= base;
            result += digit * power;
            power *= 10;
        }
        return result;
    }
}
