import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        int st = n;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (st == j) {
                    System.out.print("*\t");
                }

                else {
                    System.out.print("\t");
                }
            }
            System.out.println();
            st--;
        }
    }
}