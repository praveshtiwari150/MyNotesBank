import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        int st = n / 2 + 1;
        int sp = 1;

        for (int i = 1; i <= n; i++) {
            // print left stars
            for (int j = 1; j <= st; j++) {
                System.out.print("*");
            }

            // print spaces
            for (int j = 1; j <= sp; j++) {
                System.out.print("  ");
            }

            // print right stars
            for (int j = 1; j <= st; j++) {
                System.out.print("*");
            }

            // move to next line
            System.out.println();

            // update counts
            if (i <= n / 2) {
                st--;
                sp += 2;
            } else {
                st++;
                sp -= 2;
            }
        }
    }
}
