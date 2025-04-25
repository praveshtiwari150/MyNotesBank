import java.util.*;

public class RotateNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int temp = n;
        int nod = 0;
        while (temp > 0) {
            temp = temp / 10;
            nod++;
        }

        k = k % nod;

        if (k < 0) {
            // if negative rotations are given
            k = k + nod;
        }
        int divisor = 1;
        int multiplier = 1;

        for (int i = 1; i <= nod; i++) {
            if (i <= k) {
                divisor = divisor * 10;
            }

            else {
                multiplier = multiplier * 10;
            }
        }

        int q = n / divisor;
        int r = n % divisor;

        int roatedNumber = r * multiplier + q;
        System.out.println(roatedNumber);
    }
}
