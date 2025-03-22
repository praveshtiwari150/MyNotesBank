import java.util.Scanner;

public class Parttern9 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i || j == n - i + 1) {
                    System.out.print("*\t");
                }

                else {
                    System.out.print("-\t");
                }
            }
            System.out.println();
        }
    }
}