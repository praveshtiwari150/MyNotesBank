import java.util.*;

public class IsPrime {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the total number to input");
        int t = scn.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();

            int count = 0;
            for (int div = 2; div * div <= n; div++) {
                if (n % div == 0)
                    break;
            }

            if (count == 0) {
                System.out.println(n + " is prime");
            }
            else {
                System.out.println(n + " is not prime");
            }
        }
   }
}
